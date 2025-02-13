package com.acikgozKaan.LibraryAPI.dto.request.category;

import com.acikgozKaan.LibraryAPI.entity.Book;

import java.util.List;

public class CategorySaveRequest {

    private int id;
    private String name;
    private String description;
    private List<Book> bookList;

    public CategorySaveRequest() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
