package ru.AlexFrank.LibraryWeb.repository.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import ru.AlexFrank.LibraryWeb.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryIMPL implements BookRepository {

    private final List<Book> bookList;

    @Autowired
    public BookRepositoryIMPL(List<Book> bookList) {
        this.bookList = bookList;
    }


    @Override
    public void createNewBook(Book book) {
        try {
            book.setIdBook(System.currentTimeMillis());
            bookList.add(book);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка при создании книги", e);
        }
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookList.stream()
                .filter(t -> t.getIdBook().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Book> findBookByNameBook(String name) {
        return bookList.stream()
                .filter(t -> t.getAuthor().equals(name))
                .findAny();
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book updateBookInfo = findBookById(id).orElse(null);
        if(updateBookInfo != null){
            updateBookInfo.setName(book.getName());
            updateBookInfo.setAuthor(book.getAuthor());
            updateBookInfo.setBookYear(book.getBookYear());
            updateBookInfo.setNamePublication(book.getNamePublication());
        }
        return updateBookInfo;
    }

    @Override
    public void deleteBook(Long id) {
        findBookById(id).ifPresent(bookList::remove);
    }

    @Override
    public List<Book> showAll() {
        return bookList;
    }
}
