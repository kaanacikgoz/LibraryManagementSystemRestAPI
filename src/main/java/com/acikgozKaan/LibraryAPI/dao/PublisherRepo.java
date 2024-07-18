package com.acikgozKaan.LibraryAPI.dao;

import com.acikgozKaan.LibraryAPI.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
