package ru.LibraryAlexFrank.Library.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tbl_book_accounting")
public class BookAccounting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperation;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    @Column
    private Date startDate;

    @Column
    private Date finalDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public BookAccounting() {
    }

    public BookAccounting(User user, Book book, Date startDate, Date finalDate) {
        this.user = user;
        this.book = book;
        this.startDate = startDate;
        this.finalDate = finalDate;
    }

    @Override
    public String toString() {
        return "BookAccounting{" +
                "user=" + user +
                ", book=" + book +
                ", startDate=" + startDate +
                ", finalDate=" + finalDate +
                '}';
    }


}
