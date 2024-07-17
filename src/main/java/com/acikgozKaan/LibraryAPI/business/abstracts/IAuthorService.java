package com.acikgozKaan.LibraryAPI.business.abstracts;


import com.acikgozKaan.LibraryAPI.entity.Author;

import java.util.List;

public interface IAuthorService {

    void save(Author author);

    List<Author> get();

    Author getById(int id);

    void delete(int id);


}
