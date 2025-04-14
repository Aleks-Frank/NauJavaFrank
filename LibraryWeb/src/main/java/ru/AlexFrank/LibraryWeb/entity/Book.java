package ru.AlexFrank.LibraryWeb.entity;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@Table(name="tbl_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    private String name;

    @ManyToOne
    private Author author;

    private String namePublication;

    private int bookYear;

    public Book() {
    }

    public Book(String bookName, Author author, int bookYear, String namePublication) {
        log.info("Создан объект" + bookName + " " + author + " " + bookYear + " " + namePublication + " " + idBook);
        this.name = bookName;
        this.author = author;
        this.bookYear = bookYear;
        this.namePublication = namePublication;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getNamePublication() {
        return namePublication;
    }

    public void setNamePublication(String bookComment) {
        this.namePublication = bookComment;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + idBook +
                ", bookName='" + name + '\'' +
                ", bookAuthor='" + author + '\'' +
                ", bookYear=" + bookYear +
                ", bookComment='" + namePublication + '\'' +
                '}';
    }
}
