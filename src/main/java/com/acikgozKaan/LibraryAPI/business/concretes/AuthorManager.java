package com.acikgozKaan.LibraryAPI.business.concretes;

import com.acikgozKaan.LibraryAPI.business.abstracts.IAuthorService;
import com.acikgozKaan.LibraryAPI.core.exception.NotFoundException;
import com.acikgozKaan.LibraryAPI.core.utilies.Msg;
import com.acikgozKaan.LibraryAPI.dao.AuthorRepo;
import com.acikgozKaan.LibraryAPI.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorManager implements IAuthorService {

    private final AuthorRepo authorRepo;

    public AuthorManager(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public void save(Author author) {
        this.authorRepo.save(author);
    }

    @Override
    public List<Author> get() {
        return this.authorRepo.findAll();
    }

    @Override
    public Author getById(int id) {
        return this.authorRepo.findById(id).orElseThrow(
                ()-> new NotFoundException(Msg.NOT_FOUND)
        );
    }

    @Override
    public void delete(int id) {
        Author author = this.getById(id);
        this.authorRepo.delete(author);
    }

}
