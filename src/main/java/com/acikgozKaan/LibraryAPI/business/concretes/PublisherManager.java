package com.acikgozKaan.LibraryAPI.business.concretes;

import com.acikgozKaan.LibraryAPI.business.abstracts.IPublisherService;
import com.acikgozKaan.LibraryAPI.core.exception.NotFoundException;
import com.acikgozKaan.LibraryAPI.core.utilies.Msg;
import com.acikgozKaan.LibraryAPI.dao.PublisherRepo;
import com.acikgozKaan.LibraryAPI.entity.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherManager implements IPublisherService {

    private final PublisherRepo publisherRepo;

    public PublisherManager(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void save(Publisher publisher) {
        this.publisherRepo.save(publisher);
    }

    @Override
    public List<Publisher> get() {
        return this.publisherRepo.findAll();
    }

    @Override
    public Publisher getById(int id) {
        return this.publisherRepo.findById(id).orElseThrow(
                ()->new NotFoundException(Msg.NOT_FOUND)
        );
    }

    @Override
    public void delete(int id) {
        Publisher deletedPublisher = this.getById(id);
        this.publisherRepo.delete(deletedPublisher);
    }
}
