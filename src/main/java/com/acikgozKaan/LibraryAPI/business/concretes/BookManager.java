package com.acikgozKaan.LibraryAPI.business.concretes;

import com.acikgozKaan.LibraryAPI.business.abstracts.IBookService;
import com.acikgozKaan.LibraryAPI.core.exception.NotFoundException;
import com.acikgozKaan.LibraryAPI.core.utilies.Msg;
import com.acikgozKaan.LibraryAPI.dao.BookRepo;
import com.acikgozKaan.LibraryAPI.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements IBookService {

    private final BookRepo bookRepo;

    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public List<Book> get() {
        return bookRepo.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepo.findById(id).orElseThrow(
                ()->new NotFoundException(Msg.NOT_FOUND)
        );
    }

    @Override
    public void delete(int id) {
        Book deletedBook = this.getById(id);
        bookRepo.delete(deletedBook);
    }
}
