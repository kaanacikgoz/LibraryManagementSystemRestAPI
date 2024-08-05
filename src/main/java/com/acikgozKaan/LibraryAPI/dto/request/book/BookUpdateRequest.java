package com.acikgozKaan.LibraryAPI.dto.request.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookUpdateRequest {

    @NotNull(message = "Id can not be null or empty")
    private Long id;

    @NotBlank(message = "Name can not be null or empty")
    private String name;

    @Positive
    @NotNull(message = "Publication year can not be null or empty")
    private int publicationYear;

    @Positive
    @NotNull(message = "Stock can not be null or empty")
    private int stock;

    @NotNull(message = "Author id can not be null or empty")
    private Long authorId;

    @NotNull(message = "Publisher id can not be null or empty")
    private Long publisherId;

    BookUpdateRequest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }
}
