package com.acikgozKaan.LibraryAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",columnDefinition = "serial")
    private Long id;

    @Column(name = "author_name",nullable = false)
    private String name;

    @Column(name = "author_birthdate",nullable = false)
    private int birthDate;

    @Column(name = "author_country",nullable = false)
    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    public Author() {

    }

    public Author(String name, int birthDate, String country) {
        this.name = name;
        this.birthDate = birthDate;
        this.country = country;
    }

    public Author(String name, int birthDate, String country, List<Book> bookList) {
        this.name = name;
        this.birthDate = birthDate;
        this.country = country;
        this.bookList = bookList;
    }

    public Author(Long id, String name, int birthDate, String country, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.country = country;
        this.bookList = bookList;
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}
