package ru.LibraryAlexFrank.Library.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    private String name;

    @OneToOne
    private Author author;

    private String namePublication;

    private int bookYear;

    private String bookDescription;

    public Book() {
    }

    public Book(String bookName, Author author, int bookYear, String namePublication) {
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

    public Author getBookAuthor() {
        return author;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.author = bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getBookComment() {
        return namePublication;
    }

    public void setBookComment(String bookComment) {
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
