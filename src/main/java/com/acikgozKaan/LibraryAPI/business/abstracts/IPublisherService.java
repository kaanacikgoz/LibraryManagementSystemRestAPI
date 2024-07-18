package com.acikgozKaan.LibraryAPI.business.abstracts;

import com.acikgozKaan.LibraryAPI.entity.Publisher;

import java.util.List;

public interface IPublisherService {

    void save(Publisher publisher);

    List<Publisher> get();

    Publisher getById(int id);

    void delete(int id);

}
