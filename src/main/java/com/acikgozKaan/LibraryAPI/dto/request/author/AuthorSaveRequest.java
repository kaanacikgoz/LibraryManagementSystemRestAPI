package com.acikgozKaan.LibraryAPI.dto.request.author;

import com.acikgozKaan.LibraryAPI.entity.Book;

import java.util.List;

public class AuthorSaveRequest {

    private String name;
    private int birthDate;
    private String country;
    private List<Book> bookList;

    public AuthorSaveRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}
