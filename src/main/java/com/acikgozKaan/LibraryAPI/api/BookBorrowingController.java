package com.acikgozKaan.LibraryAPI.api;

import com.acikgozKaan.LibraryAPI.business.abstracts.IBookBorrowingService;
import com.acikgozKaan.LibraryAPI.business.abstracts.IBookService;
import com.acikgozKaan.LibraryAPI.core.result.ResultData;
import com.acikgozKaan.LibraryAPI.core.utilies.ResultHelper;
import com.acikgozKaan.LibraryAPI.dto.request.bookBorrowing.BookBorrowingSaveRequest;
import com.acikgozKaan.LibraryAPI.dto.response.BookBorrowingResponse;
import com.acikgozKaan.LibraryAPI.entity.Book;
import com.acikgozKaan.LibraryAPI.entity.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookBorrowings")
public class BookBorrowingController {

    private final IBookBorrowingService bookBorrowingService;
    private final IBookService bookService;

    public BookBorrowingController(IBookBorrowingService bookBorrowingService, IBookService bookService) {
        this.bookBorrowingService = bookBorrowingService;
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResultData<BookBorrowingResponse> save(@Valid @RequestBody BookBorrowingSaveRequest bookBorrowingSaveRequest) {

        Book book = this.bookService.getById(bookBorrowingSaveRequest.getBook().getId());

        BookBorrowing bookBorrowing = new BookBorrowing(
                bookBorrowingSaveRequest.getBorrowerName(),
                bookBorrowingSaveRequest.getBorrowingDate(),
                bookBorrowingSaveRequest.getReturnDate(),
                book
        );

        this.bookBorrowingService.save(bookBorrowing);

        BookBorrowingResponse bookBorrowingResponse = new BookBorrowingResponse(
                bookBorrowing.getId(),
                bookBorrowing.getBorrowerName(),
                bookBorrowing.getBorrowingDate(),
                bookBorrowing.getReturnDate(),
                bookBorrowing.getBook()
        );

        return ResultHelper.created(bookBorrowingResponse);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<BookBorrowing> get() {
        return this.bookBorrowingService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResultData<BookBorrowing> delete(@PathVariable("id")Long id) {
        BookBorrowing deletedBookBorrowing = this.bookBorrowingService.getById(id);
        this.bookBorrowingService.delete(id);
        return ResultHelper.deleted(deletedBookBorrowing);
    }

}
