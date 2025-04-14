package ru.AlexFrank.LibraryWeb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.AlexFrank.LibraryWeb.entity.Book;

public interface BookRepositoryDB extends CrudRepository<Book, Long> {
}
