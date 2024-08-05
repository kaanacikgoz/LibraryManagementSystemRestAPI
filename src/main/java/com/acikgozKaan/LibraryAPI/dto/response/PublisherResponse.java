package com.acikgozKaan.LibraryAPI.dto.response;

import com.acikgozKaan.LibraryAPI.entity.Book;

import java.util.List;

public class PublisherResponse {

    private Long id;
    private String name;
    private int establishmentYear;
    private String address;
    private List<Book> bookList;

    public PublisherResponse() {
    }

    public PublisherResponse(Long id, String name, int establishmentYear, String address, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.establishmentYear = establishmentYear;
        this.address = address;
        this.bookList = bookList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}
