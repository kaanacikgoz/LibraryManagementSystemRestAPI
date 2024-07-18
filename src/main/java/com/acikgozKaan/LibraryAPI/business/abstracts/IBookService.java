package com.acikgozKaan.LibraryAPI.business.abstracts;

import com.acikgozKaan.LibraryAPI.entity.Book;

import java.util.List;

public interface IBookService {

    void save(Book book);

    List<Book> get();

    Book getById(int id);

    void delete(int id);

}
