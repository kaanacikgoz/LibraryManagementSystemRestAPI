package com.acikgozKaan.LibraryAPI.api;

import com.acikgozKaan.LibraryAPI.business.abstracts.IAuthorService;
import com.acikgozKaan.LibraryAPI.business.abstracts.IBookService;
import com.acikgozKaan.LibraryAPI.business.abstracts.ICategoryService;
import com.acikgozKaan.LibraryAPI.business.abstracts.IPublisherService;
import com.acikgozKaan.LibraryAPI.core.exception.NotFoundException;
import com.acikgozKaan.LibraryAPI.core.result.ResultData;
import com.acikgozKaan.LibraryAPI.core.utilies.ResultHelper;
import com.acikgozKaan.LibraryAPI.dto.request.author.AuthorUpdateRequest;
import com.acikgozKaan.LibraryAPI.dto.request.book.BookSaveRequest;
import com.acikgozKaan.LibraryAPI.dto.request.book.BookUpdateRequest;
import com.acikgozKaan.LibraryAPI.dto.response.AuthorResponse;
import com.acikgozKaan.LibraryAPI.dto.response.BookResponse;
import com.acikgozKaan.LibraryAPI.entity.Author;
import com.acikgozKaan.LibraryAPI.entity.Book;
import com.acikgozKaan.LibraryAPI.entity.Category;
import com.acikgozKaan.LibraryAPI.entity.Publisher;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final IBookService bookService;
    private final IAuthorService authorService;
    private final IPublisherService publisherService;
    private final ICategoryService categoryService;


    public BookController(IBookService bookService, IAuthorService authorService, IPublisherService publisherService, ICategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest) {

        Author author = authorService.getById(bookSaveRequest.getAuthorId());

        Publisher publisher = publisherService.getById(bookSaveRequest.getPublisherId());

        Book book = new Book(
                bookSaveRequest.getName(),
                bookSaveRequest.getPublicationYear(),
                bookSaveRequest.getStock(),
                author,
                publisher
        );

        bookService.save(book);

        BookResponse bookResponse = new BookResponse(
                book.getId(),
                book.getName(),
                book.getPublicationYear(),
                book.getStock(),
                book.getAuthor(),
                book.getPublisher(),
                book.getBookBorrowingList(),
                book.getCategoryList()
        );

        return ResultHelper.created(bookResponse);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private ResultData<List<BookResponse>> get() {
        List<BookResponse> books = bookService.getAll().stream().map(
                book -> new BookResponse(
                        book.getId(),
                        book.getName(),
                        book.getPublicationYear(),
                        book.getStock(),
                        book.getAuthor(),
                        book.getPublisher(),
                        book.getBookBorrowingList(),
                        book.getCategoryList()
                )
        ).collect(Collectors.toList());

        return ResultHelper.ok(books);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResultData<BookResponse> update(@PathVariable("id") Long id,
                                              @Valid @RequestBody BookUpdateRequest bookUpdateRequest)
    {

        if (!bookUpdateRequest.getId().equals(id)) {
            throw new NotFoundException("Id can not be different!");
        }

        Author author = authorService.getById(bookUpdateRequest.getAuthorId());

        Publisher publisher = publisherService.getById(bookUpdateRequest.getPublisherId());

        Book book2 = bookService.getById(id);


        Book book = new Book(
                bookUpdateRequest.getId(),
                bookUpdateRequest.getName(),
                bookUpdateRequest.getPublicationYear(),
                bookUpdateRequest.getStock(),
                author,
                publisher,
                book2.getBookBorrowingList(),
                book2.getCategoryList()
        );

        bookService.update(book);

        BookResponse bookResponse = new BookResponse(
                book.getId(),
                book.getName(),
                book.getPublicationYear(),
                book.getStock(),
                book.getAuthor(),
                book.getPublisher(),
                book.getBookBorrowingList(),
                book.getCategoryList()
        );

        return ResultHelper.updated(bookResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResultData<BookResponse> delete(@PathVariable("id")Long id) {
        Book deletedBook = this.bookService.getById(id);
        this.bookService.delete(id);
        BookResponse bookResponse = new BookResponse(
                deletedBook.getId(),
                deletedBook.getName(),
                deletedBook.getPublicationYear(),
                deletedBook.getStock(),
                deletedBook.getAuthor(),
                deletedBook.getPublisher(),
                deletedBook.getBookBorrowingList(),
                deletedBook.getCategoryList()
        );
        return ResultHelper.deleted(bookResponse);
    }

}
