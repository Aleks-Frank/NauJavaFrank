package ru.LibraryAlexFrank.Library.DBRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.LibraryAlexFrank.Library.Entity.Book;

public interface BookDBRepository extends JpaRepository<Book, Integer> {
}
