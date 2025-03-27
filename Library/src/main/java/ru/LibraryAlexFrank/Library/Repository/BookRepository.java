package ru.LibraryAlexFrank.Library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.LibraryAlexFrank.Library.entity.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByBookName(String name);

    @Query("FROM Book WHERE author.name = :name")
    List<Book> findByAuthorName(String name);

}
