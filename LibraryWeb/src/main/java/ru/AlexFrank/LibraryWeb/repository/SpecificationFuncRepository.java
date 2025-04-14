package ru.AlexFrank.LibraryWeb.repository;

import ru.AlexFrank.LibraryWeb.entity.Author;
import ru.AlexFrank.LibraryWeb.entity.Book;

public interface SpecificationFuncRepository {
    Author create(String name);

    Book update(Book book, BookRepositoryDB bookRepositoryDB);

    Author createNewAuthor(String author);
}
