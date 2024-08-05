package com.acikgozKaan.LibraryAPI.business.abstracts;

import com.acikgozKaan.LibraryAPI.entity.BookBorrowing;

import java.util.List;

public interface IBookBorrowingService {

    void save(BookBorrowing bookBorrowing);

    List<BookBorrowing> getAll();

    BookBorrowing getById(Long id);

    void delete(Long id);

}
