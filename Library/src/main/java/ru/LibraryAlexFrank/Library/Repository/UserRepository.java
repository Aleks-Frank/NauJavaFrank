package ru.LibraryAlexFrank.Library.repository;

import org.springframework.data.repository.CrudRepository;
import ru.LibraryAlexFrank.Library.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
