package com.acikgozKaan.LibraryAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookBorrowings")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookborrow_id",columnDefinition = "serial")
    private Long id;

    @Column(name = "borrower_name",nullable = false)
    private String borrowerName;

    @Column(name = "borrowing_date",nullable = false)
    private LocalDate borrowingDate;

    @Column(name = "borrow_returndate")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "bookborrowing_book_id", referencedColumnName = "book_id")
    private Book book;

    public BookBorrowing() {

    }

    public BookBorrowing(String borrowerName, LocalDate borrowingDate, LocalDate returnDate, Book book) {
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
