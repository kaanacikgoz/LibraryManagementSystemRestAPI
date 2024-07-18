package com.acikgozKaan.LibraryAPI.api;

import com.acikgozKaan.LibraryAPI.business.abstracts.ICategoryService;
import com.acikgozKaan.LibraryAPI.core.result.ResultData;
import com.acikgozKaan.LibraryAPI.core.utilies.ResultHelper;
import com.acikgozKaan.LibraryAPI.dto.request.category.CategorySaveRequest;
import com.acikgozKaan.LibraryAPI.dto.response.CategoryResponse;
import com.acikgozKaan.LibraryAPI.entity.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest) {

        Category category = new Category(
                categorySaveRequest.getName(),
                categorySaveRequest.getDescription(),
                categorySaveRequest.getBookList()
        );

        this.categoryService.save(category);

        CategoryResponse categoryResponse = new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getBookList()
        );

        return ResultHelper.created(categoryResponse);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Category> get() {
        return this.categoryService.get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResultData<Category> delete(@PathVariable("id")int id) {
        Category deletedCategory = this.categoryService.getById(id);
        this.categoryService.delete(id);
        return ResultHelper.deleted(deletedCategory);
    }

}
