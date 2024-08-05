package com.acikgozKaan.LibraryAPI.business.abstracts;

import com.acikgozKaan.LibraryAPI.entity.Publisher;

import java.util.List;

public interface IPublisherService {

    void save(Publisher publisher);

    List<Publisher> getAll();

    Publisher getById(Long id);

    void delete(Long id);

}
