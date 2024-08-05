package com.acikgozKaan.LibraryAPI.dao;

import com.acikgozKaan.LibraryAPI.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    List<Category> findAllById(Iterable<Long> ids);

}
