package com.acikgozKaan.LibraryAPI.business.abstracts;

import com.acikgozKaan.LibraryAPI.entity.Category;

import java.util.List;

public interface ICategoryService {

    void save(Category category);

    List<Category> getAll();

    Category getById(Long id);

    public List<Category> getByIds(List<Long> ids);

    void delete(Long id);

}
