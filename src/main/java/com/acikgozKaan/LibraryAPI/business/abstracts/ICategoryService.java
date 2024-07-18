package com.acikgozKaan.LibraryAPI.business.abstracts;

import com.acikgozKaan.LibraryAPI.entity.Category;

import java.util.List;

public interface ICategoryService {

    void save(Category category);

    List<Category> get();

    Category getById(int id);

    void delete(int id);

}
