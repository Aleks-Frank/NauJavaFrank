package ru.AlexFrank.LibraryWeb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.AlexFrank.LibraryWeb.entity.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryIMPL implements AuthorRepository{

    private final List<Author> authors;

    @Autowired
    public AuthorRepositoryIMPL(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public void createNewAuthor(String author) {
        String[] name = author.split(" ");
        Author newAuthor = new Author(name[0], name[1], name[2]);
        newAuthor.setIdAuthor(System.currentTimeMillis());
        authors.add(newAuthor);
    }
}
