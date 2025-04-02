package ru.AlexFrank.LibraryWeb.service;

import ru.AlexFrank.LibraryWeb.entity.Book;

import java.util.List;
import java.util.Optional;

public interface LibraryService {

    void createNewBook(Book book);

    Optional<Book> findBookById(Long id);

    Optional<Book> findBookByNameBook(String name);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);

    List<Book> showAll();

}
