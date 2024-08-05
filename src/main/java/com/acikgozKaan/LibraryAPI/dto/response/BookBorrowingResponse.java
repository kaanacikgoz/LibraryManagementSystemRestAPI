package com.acikgozKaan.LibraryAPI.dto.response;

import com.acikgozKaan.LibraryAPI.entity.Book;

import java.time.LocalDate;

public class BookBorrowingResponse {

    private Long id;
    private String borrowerName;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private Book book;

    public BookBorrowingResponse() {

    }

    public BookBorrowingResponse(Long id, String borrowerName, LocalDate borrowingDate, LocalDate returnDate, Book book) {
        this.id = id;
        this.borrowerName = borrowerName;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
