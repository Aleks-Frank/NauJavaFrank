package ru.LibraryAlexFrank.Library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.LibraryAlexFrank.Library.entity.Author;
import ru.LibraryAlexFrank.Library.entity.Book;
import ru.LibraryAlexFrank.Library.repository.AuthorRepository;
import ru.LibraryAlexFrank.Library.repository.BookRepository;
import ru.LibraryAlexFrank.Library.repository.BookRepositoryCustom;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LibraryApplicationTests {

	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookRepositoryCustom bookRepositoryCustom;

	@Test
	void addBook() {
		Author authorOne = new Author("Alex", "Frank", "Antonovis");
		Author authorTwo = new Author("Nikita", "Graf", "Fedorov");
		authorRepository.save(authorOne);
		authorRepository.save(authorTwo);
		Book bookOne = new Book("Harry Bin and Flip", authorOne, 2013, "VOID");
		Book bookTwo = new Book("Gravity", authorTwo, 2003, "Sumba");

		bookRepository.save(bookOne);
		bookRepository.save(bookTwo);

	}

	@Test
	void testFindByBookName() {
		List<Book> books = bookRepository.findByBookName("Gravity");
	}

	@Test
	void testFindByAuthorName() {
		List<Book> books = bookRepository.findByAuthorName("Alex");
	}

	@Test
	void testFindByBookNameCustom() {
		List<Book> books = bookRepositoryCustom.findByBookName("Gravity");
	}

	@Test
	void testFindByAuthorNameCustom() {
		List<Book> books = bookRepositoryCustom.findByAuthorName("Alex");
	}

}
