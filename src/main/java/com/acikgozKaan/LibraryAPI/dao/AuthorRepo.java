package com.acikgozKaan.LibraryAPI.dao;

import com.acikgozKaan.LibraryAPI.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
