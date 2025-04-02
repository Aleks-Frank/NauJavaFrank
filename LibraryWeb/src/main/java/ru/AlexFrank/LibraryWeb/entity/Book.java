package ru.AlexFrank.LibraryWeb.entity;

public class Book {

    private Long idBook;

    private String name;

    private String author;

    private String namePublication;

    private int bookYear;

    public Book() {
    }

    public Book(String bookName, String author, int bookYear, String namePublication) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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
