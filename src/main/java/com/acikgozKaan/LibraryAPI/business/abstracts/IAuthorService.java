package com.acikgozKaan.LibraryAPI.business.abstracts;


import com.acikgozKaan.LibraryAPI.entity.Author;

import java.util.List;

public interface IAuthorService {

    void save(Author author);

    void update(Author author);

    List<Author> getAll();

    Author getById(Long id);

    void delete(Long id);


}
