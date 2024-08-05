package com.acikgozKaan.LibraryAPI.dto.request.bookBorrowing;

import com.acikgozKaan.LibraryAPI.entity.Book;

import java.time.LocalDate;

public class BookBorrowingSaveRequest {

    private String borrowerName;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private Book book;

    public BookBorrowingSaveRequest() {

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
