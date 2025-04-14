package ru.AlexFrank.LibraryWeb.repository;

import org.springframework.stereotype.Repository;
import ru.AlexFrank.LibraryWeb.entity.Author;
import ru.AlexFrank.LibraryWeb.entity.Book;

@Repository
public class SpecificationFuncRepositoryIMPL implements SpecificationFuncRepository{
    @Override
    public Author create(String name) {
        String[] name_a = name.split(" ");
        return new Author(name_a[0], name_a[1], name_a[2]);
    }

    @Override
    public Book update(Book book, BookRepositoryDB bookRepositoryDB) {
        Long id = book.getIdBook();
        bookRepositoryDB.deleteById(id);
        book.setIdBook(id);
        book.setName(book.getName());
        book.setAuthor(book.getAuthor());
        book.setBookYear(book.getBookYear());
        book.setNamePublication(book.getNamePublication());

        return bookRepositoryDB.save(book);
    }

    @Override
    public Author createNewAuthor(String author) {
        String[] name = author.split(" ");
        Author newAuthor = new Author(name[0], name[1], name[2]);
        newAuthor.setIdAuthor(System.currentTimeMillis());
        return newAuthor;
    }
}
