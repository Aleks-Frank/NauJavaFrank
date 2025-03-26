package ru.LibraryAlexFrank.Library.Repository;

import ru.LibraryAlexFrank.Library.Entity.Book;

import java.util.Optional;

public interface BookRepository {

    void createNewBook(Book book);

    Optional<Book> findBookById(Long id);

    Optional<Book> findBookByNameBook(String name);

    void bookBorrow(Long id, Boolean statusBook);

    Book updateBook(Long id, Book book);

    String nameBusyBook(Long id);

    void deleteBook(Long id);

    void showAll();

}
