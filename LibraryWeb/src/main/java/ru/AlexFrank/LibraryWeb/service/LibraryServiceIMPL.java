package ru.AlexFrank.LibraryWeb.service;

import org.springframework.stereotype.Service;
import ru.AlexFrank.LibraryWeb.entity.Book;
import ru.AlexFrank.LibraryWeb.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceIMPL implements LibraryService{

    private final BookRepository bookRepository;

    public LibraryServiceIMPL(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void createNewBook(Book book) {
        bookRepository.createNewBook(book);
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public Optional<Book> findBookByNameBook(String name) {
        return bookRepository.findBookByNameBook(name);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return bookRepository.updateBook(id, book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public List<Book> showAll() {
        return bookRepository.showAll();
    }
}
