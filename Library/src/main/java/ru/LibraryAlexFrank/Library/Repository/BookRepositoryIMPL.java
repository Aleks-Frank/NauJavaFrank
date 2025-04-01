package ru.LibraryAlexFrank.Library.repository;

import jakarta.persistence.Access;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.LibraryAlexFrank.Library.entity.Author;
import ru.LibraryAlexFrank.Library.entity.Book;

import java.util.List;

public class BookRepositoryIMPL implements BookRepositoryCustom{

    private final EntityManager entityManager;

    @Autowired
    public BookRepositoryIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> findByBookName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> bookRoot = criteriaQuery.from(Book.class);
        Predicate predicate = criteriaBuilder.equal(bookRoot.get("name"), name);

        criteriaQuery.select(bookRoot).where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Book> findByAuthorName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> bookRoot = criteriaQuery.from(Book.class);
        Join<Book, Author> author = bookRoot.join("author", JoinType.INNER);
        Predicate predicate = criteriaBuilder.equal(author.get("name"), name);

        criteriaQuery.select(bookRoot).where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
