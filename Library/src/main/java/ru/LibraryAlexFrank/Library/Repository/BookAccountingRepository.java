package ru.LibraryAlexFrank.Library.repository;

import org.springframework.data.repository.CrudRepository;
import ru.LibraryAlexFrank.Library.entity.BookAccounting;

public interface BookAccountingRepository extends CrudRepository<BookAccounting, Long> {
}
