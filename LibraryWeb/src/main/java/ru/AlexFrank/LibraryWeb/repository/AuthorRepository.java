package ru.AlexFrank.LibraryWeb.repository;

import ru.AlexFrank.LibraryWeb.entity.Author;
import ru.AlexFrank.LibraryWeb.entity.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    void createNewAuthor(String author);

}
