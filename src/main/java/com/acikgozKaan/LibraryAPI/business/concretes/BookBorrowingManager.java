package com.acikgozKaan.LibraryAPI.business.concretes;

import com.acikgozKaan.LibraryAPI.business.abstracts.IBookBorrowingService;
import com.acikgozKaan.LibraryAPI.core.exception.NotFoundException;
import com.acikgozKaan.LibraryAPI.core.utilies.Msg;
import com.acikgozKaan.LibraryAPI.dao.BookBorrowingRepo;
import com.acikgozKaan.LibraryAPI.entity.BookBorrowing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingManager implements IBookBorrowingService {

    private final BookBorrowingRepo bookBorrowingRepo;

    public BookBorrowingManager(BookBorrowingRepo bookBorrowingRepo) {
        this.bookBorrowingRepo = bookBorrowingRepo;
    }

    @Override
    public void save(BookBorrowing bookBorrowing) {
        this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public List<BookBorrowing> getAll() {
        return this.bookBorrowingRepo.findAll();
    }

    @Override
    public BookBorrowing getById(Long id) {
        return this.bookBorrowingRepo.findById(id).orElseThrow(
                ()->new NotFoundException(Msg.NOT_FOUND)
        );
    }

    @Override
    public void delete(Long id) {
        BookBorrowing deletedBookBorrowing = this.getById(id);
        this.bookBorrowingRepo.delete(deletedBookBorrowing);
    }

}
