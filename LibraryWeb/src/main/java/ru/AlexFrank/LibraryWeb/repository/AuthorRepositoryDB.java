package ru.AlexFrank.LibraryWeb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.AlexFrank.LibraryWeb.entity.Author;

public interface AuthorRepositoryDB extends CrudRepository<Author, Long> {
}
