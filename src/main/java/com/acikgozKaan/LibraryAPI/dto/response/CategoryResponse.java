package com.acikgozKaan.LibraryAPI.dto.response;

import com.acikgozKaan.LibraryAPI.entity.Book;

import java.util.List;

public class CategoryResponse {

    private Long id;
    private String name;
    private String description;
    private List<Book> bookList;

    public CategoryResponse() {

    }

    public CategoryResponse(Long id, String name, String description, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}
