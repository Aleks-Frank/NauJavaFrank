package ru.LibraryAlexFrank.Library.repository;

import org.springframework.data.repository.CrudRepository;
import ru.LibraryAlexFrank.Library.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
