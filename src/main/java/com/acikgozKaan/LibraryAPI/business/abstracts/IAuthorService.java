package com.acikgozKaan.LibraryAPI.business.abstracts;


import com.acikgozKaan.LibraryAPI.entity.Author;

import java.util.List;

public interface IAuthorService {

    Author save(Author author);

    List<Author> get();


}
