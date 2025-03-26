package ru.LibraryAlexFrank.Library.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.LibraryAlexFrank.Library.Entity.Book;

import java.util.List;
import java.util.Optional;

@Component
public class BookRepositoryIMPL implements BookRepository{

    private final List<Book> bookList;

    @Autowired
    public BookRepositoryIMPL(List<Book> bookList) {
        this.bookList = bookList;
    }


    @Override
    public void createNewBook(Book book) {
        bookList.add(book);
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Book> findBookByNameBook(String name) {
        return bookList.stream()
                .filter(t -> t.getBookAuthor().equals(name))
                .findAny();
    }

    @Override
    public void bookBorrow(Long id, Boolean statusBook) {
        findBookById(id).ifPresent(updateBookInfo -> updateBookInfo.setBookInLibrary(statusBook));
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book updateBookInfo = findBookById(id).orElse(null);
        if(updateBookInfo != null){
            updateBookInfo.setBookName(book.getBookName());
            updateBookInfo.setBookAuthor(book.getBookAuthor());
            updateBookInfo.setBookYear(book.getBookYear());
            updateBookInfo.setBookComment(book.getBookComment());
            updateBookInfo.setBookInLibrary(book.getBookInLibrary());
            updateBookInfo.setBookNameBusy(book.getBookNameBusy());
            updateBookInfo.setBookFinalDataBusy(book.getBookFinalDataBusy());
        }
        return updateBookInfo;
    }

    @Override
    public String nameBusyBook(Long id) {
        Book bookInfo = findBookById(id).orElse(null);
        if(bookInfo != null){
            return bookInfo.getBookNameBusy();
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        findBookById(id).ifPresent(bookList::remove);
    }

    @Override
    public void showAll() {
        for(Book book : bookList){
            System.out.println(book.toString());
        }
    }
}
