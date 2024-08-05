package com.acikgozKaan.LibraryAPI.dao;

import com.acikgozKaan.LibraryAPI.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
