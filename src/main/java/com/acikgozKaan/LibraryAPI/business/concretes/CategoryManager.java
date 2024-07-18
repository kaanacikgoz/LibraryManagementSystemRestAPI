package com.acikgozKaan.LibraryAPI.business.concretes;

import com.acikgozKaan.LibraryAPI.business.abstracts.ICategoryService;
import com.acikgozKaan.LibraryAPI.core.exception.NotFoundException;
import com.acikgozKaan.LibraryAPI.core.utilies.Msg;
import com.acikgozKaan.LibraryAPI.dao.CategoryRepo;
import com.acikgozKaan.LibraryAPI.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void save(Category category) {
        this.categoryRepo.save(category);
    }

    @Override
    public List<Category> get() {
        return this.categoryRepo.findAll();
    }

    @Override
    public Category getById(int id) {
        return this.categoryRepo.findById(id).orElseThrow(
                ()->new NotFoundException(Msg.NOT_FOUND)
        );
    }

    @Override
    public void delete(int id) {
        Category deletedCategory = this.getById(id);
        this.categoryRepo.delete(deletedCategory);
    }

}
