package com.acikgozKaan.LibraryAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id",columnDefinition = "serial")
    private Long id;

    @Column(name = "publisher_name",nullable = false)
    private String name;

    @Column(name = "publisher_establishmentyear",nullable = false)
    private int establishmentYear;

    @Column(name = "publisher_address",nullable = false)
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL)
    private List<Book> bookList;

    public Publisher() {

    }

    public Publisher(String name, int establishmentYear, String address, List<Book> bookList) {
        this.name = name;
        this.establishmentYear = establishmentYear;
        this.address = address;
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

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}
