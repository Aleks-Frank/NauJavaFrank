package ru.AlexFrank.LibraryWeb.entity;

import java.util.Date;

public class BookAccounting {

    private Long idOperation;

    private User user;

    private Book book;

    private Date startDate;

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
