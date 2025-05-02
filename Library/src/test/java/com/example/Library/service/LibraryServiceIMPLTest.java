package com.example.Library.service;

import com.example.Library.entity.Book;
import com.example.Library.repository.BookRepositoryDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryServiceIMPLTest {

    @Mock
    private BookRepositoryDB bookRepositoryDB;

    @InjectMocks
    private LibraryServiceIMPL libraryService;

    @Test
    void createNewBook() {
        Book book = new Book("Book Test", "Fi Kin", 2000);

        Mockito.when(bookRepositoryDB.save(book)).thenReturn(book);

        libraryService.createNewBook(book);

        Mockito.verify(bookRepositoryDB, Mockito.times(1)).save(book);

    }

    @Test
    void findBookById() {
        Long bookId = 1L;
        Book book = new Book("Sim Test", "Fina Kim", 2013);

        Mockito.when(bookRepositoryDB.findById(bookId)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = libraryService.findBookById(bookId);

        Assertions.assertTrue(foundBook.isPresent());
        Assertions.assertEquals(book, foundBook.get());
    }

    @Test
    void noFindBookByNameBook() {
        String bookName = "No name";

        Mockito.when(bookRepositoryDB.findByName(bookName)).thenReturn(Optional.empty());

        Optional<Book> foundBook = libraryService.findBookByNameBook(bookName);

        Assertions.assertTrue(foundBook.isEmpty());
    }

    @Test
    void deleteBook() {
        Long bookId = 100L;

        Mockito.doThrow(new EmptyResultDataAccessException(1)).when(bookRepositoryDB).deleteById(bookId);

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            libraryService.deleteBook(bookId);
        });
    }
}