package com.acikgozKaan.LibraryAPI.business.abstracts;

import com.acikgozKaan.LibraryAPI.entity.Book;

import java.util.List;

public interface IBookService {

    void save(Book book);

    void update(Book book);

    List<Book> getAll();

    Book getById(Long id);

    void delete(Long id);

}
