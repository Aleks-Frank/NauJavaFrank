package ru.LibraryAlexFrank.Library.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="book_tbl")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    private String bookAuthor;

    private int bookYear;

    private String bookComment;

    private Boolean isBookInLibrary = true;

    private String bookNameBusy = null;

    private LocalDate bookFinalDataBusy = null;

    public Book() {
    }

    public Book(String bookName, String bookAuthor, int bookYear, String bookComment) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookComment = bookComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getBookComment() {
        return bookComment;
    }

    public void setBookComment(String bookComment) {
        this.bookComment = bookComment;
    }

    public Boolean getBookInLibrary() {
        return isBookInLibrary;
    }

    public void setBookInLibrary(Boolean bookInLibrary) {
        isBookInLibrary = bookInLibrary;
    }

    public String getBookNameBusy() {
        return bookNameBusy;
    }

    public void setBookNameBusy(String bookNameBusy) {
        this.bookNameBusy = bookNameBusy;
    }

    public LocalDate getBookFinalDataBusy() {
        return bookFinalDataBusy;
    }

    public void setBookFinalDataBusy(LocalDate bookFinalDataBusy) {
        this.bookFinalDataBusy = bookFinalDataBusy;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookYear=" + bookYear +
                ", bookComment='" + bookComment + '\'' +
                ", isBookInLibrary=" + isBookInLibrary +
                ", bookNameBusy='" + bookNameBusy + '\'' +
                ", bookFinalDataBusy=" + bookFinalDataBusy +
                '}';
    }
}
