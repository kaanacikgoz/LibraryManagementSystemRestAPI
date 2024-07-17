package com.acikgozKaan.LibraryAPI.api;

import com.acikgozKaan.LibraryAPI.business.abstracts.IAuthorService;
import com.acikgozKaan.LibraryAPI.core.result.ResultData;
import com.acikgozKaan.LibraryAPI.core.utilies.ResultHelper;
import com.acikgozKaan.LibraryAPI.dto.request.author.AuthorSaveRequest;
import com.acikgozKaan.LibraryAPI.dto.response.AuthorResponse;
import com.acikgozKaan.LibraryAPI.entity.Author;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest) {

        Author author = new Author(
                authorSaveRequest.getName(),
                authorSaveRequest.getBirthDate(),
                authorSaveRequest.getCountry(),
                authorSaveRequest.getBookList()
        );

        this.authorService.save(author);

        AuthorResponse authorResponse = new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBirthDate(),
                author.getCountry(),
                author.getBookList()
        );

        return ResultHelper.created(authorResponse);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Author> get() {
        return this.authorService.get();
    }

}
