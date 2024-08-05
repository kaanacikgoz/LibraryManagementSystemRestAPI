package com.acikgozKaan.LibraryAPI.dao;

import com.acikgozKaan.LibraryAPI.entity.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowingRepo extends JpaRepository<BookBorrowing, Long> {
}
