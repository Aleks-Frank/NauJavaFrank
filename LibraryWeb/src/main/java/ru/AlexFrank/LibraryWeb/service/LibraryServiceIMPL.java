package ru.AlexFrank.LibraryWeb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.AlexFrank.LibraryWeb.entity.Book;
import ru.AlexFrank.LibraryWeb.repository.AuthorRepositoryDB;
import ru.AlexFrank.LibraryWeb.repository.BookRepositoryDB;
import ru.AlexFrank.LibraryWeb.repository.SpecificationFuncRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LibraryServiceIMPL implements LibraryService{

    private final BookRepositoryDB bookRepositoryDB;

    private final AuthorRepositoryDB authorRepositoryDB;

    private final SpecificationFuncRepository specificationFuncRepository;

    public LibraryServiceIMPL(BookRepositoryDB bookRepositoryDB, AuthorRepositoryDB authorRepositoryDB, SpecificationFuncRepository specificationFuncRepository) {
        this.bookRepositoryDB = bookRepositoryDB;
        this.authorRepositoryDB = authorRepositoryDB;
        this.specificationFuncRepository = specificationFuncRepository;
    }


    @Override
    public void createNewBook(Book book) {
        log.info("Создана новая книга");
//        specificationFuncRepository.createNewAuthor();
        bookRepositoryDB.save(book);
        authorRepositoryDB.save(book.getAuthor());
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        log.info("Найдиа книга " + id);
        return bookRepositoryDB.findById(id);
    }

    @Override
    public Book updateBook(Book book) {
        log.info("Книга обновлена");
        return specificationFuncRepository.update(book, bookRepositoryDB);
    }

    @Override
    public void deleteBook(Long id) {
        log.info("Книга удалена");
        bookRepositoryDB.deleteById(id);
    }

    @Override
    public List<Book> showAll() {
        log.info("Найдены все");
        return (List<Book>) bookRepositoryDB.findAll();
    }
}
