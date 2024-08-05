package com.acikgozKaan.LibraryAPI.api;

import com.acikgozKaan.LibraryAPI.business.abstracts.IAuthorService;
import com.acikgozKaan.LibraryAPI.core.exception.NotFoundException;
import com.acikgozKaan.LibraryAPI.core.result.ResultData;
import com.acikgozKaan.LibraryAPI.core.utilies.ResultHelper;
import com.acikgozKaan.LibraryAPI.dto.request.author.AuthorSaveRequest;
import com.acikgozKaan.LibraryAPI.dto.request.author.AuthorUpdateRequest;
import com.acikgozKaan.LibraryAPI.dto.response.AuthorResponse;
import com.acikgozKaan.LibraryAPI.entity.Author;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest) {

        Author author = new Author(
                authorSaveRequest.getName(),
                authorSaveRequest.getBirthDate(),
                authorSaveRequest.getCountry()
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
    public ResultData<List<AuthorResponse>> getAll() {
        List<Author> authors = authorService.getAll();

        List<AuthorResponse> authorResponses = authors.stream().map(author -> new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBirthDate(),
                author.getCountry(),
                author.getBookList()
        )).collect(Collectors.toList());

        return ResultHelper.ok(authorResponses);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update(@PathVariable("id") Long id,
                                              @Valid @RequestBody AuthorUpdateRequest authorUpdateRequest)
    {

        if (!authorUpdateRequest.getId().equals(id)) {
            throw new NotFoundException("Id can not be different!");
        }

        Author author2 = authorService.getById(authorUpdateRequest.getId());

        Author author = new Author(
                authorUpdateRequest.getId(),
                authorUpdateRequest.getName(),
                authorUpdateRequest.getBirthDate(),
                authorUpdateRequest.getCountry(),
                author2.getBookList()
        );

        authorService.update(author);

        AuthorResponse authorResponse = new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBirthDate(),
                author.getCountry(),
                author.getBookList()
        );

        return ResultHelper.updated(authorResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<Author> delete(@PathVariable("id")Long id) {
        Author deletedAuthor = this.authorService.getById(id);
        this.authorService.delete(id);
        return ResultHelper.deleted(deletedAuthor);
    }

}
