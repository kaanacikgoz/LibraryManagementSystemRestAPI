package com.acikgozKaan.LibraryAPI.dto.request.author;

import jakarta.validation.constraints.*;

public class AuthorSaveRequest {

    @NotBlank(message = "Name can not be null or empty")
    private String name;
    @NotNull(message = "BirthDate can not be null or empty")
    @Min(value = 1900, message = "BirthDate should not be before 1900")
    @Max(value = 2024, message = "BirthDate should not be after 2024")
    private Integer birthDate;
    @NotBlank(message = "Country can not be null or empty")
    private String country;

    public AuthorSaveRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
