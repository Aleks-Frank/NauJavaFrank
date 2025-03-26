package ru.LibraryAlexFrank.Library.Service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.LibraryAlexFrank.Library.Entity.Book;
import ru.LibraryAlexFrank.Library.Repository.BookRepository;

import java.util.Optional;

public class UserLibraryService implements LibraryService{

    private final BookRepository bookRepository;

    @Autowired
    public UserLibraryService(BookRepository bookRepository) {
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
    public void bookBorrow(Long id, Boolean statusBook) {
        bookRepository.bookBorrow(id, statusBook);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return bookRepository.updateBook(id, book);
    }

    @Override
    public String nameBusyBook(Long id) {
        return bookRepository.nameBusyBook(id);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public void showAll() {
        bookRepository.showAll();
    }
}
