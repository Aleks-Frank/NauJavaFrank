package ru.LibraryAlexFrank.Library.repository;

import org.springframework.data.jpa.repository.Query;
import ru.LibraryAlexFrank.Library.entity.Book;

import java.util.List;

public interface BookRepositoryCustom {

    List<Book> findByBookName(String name);

    List<Book> findByAuthorName(String name);

}
