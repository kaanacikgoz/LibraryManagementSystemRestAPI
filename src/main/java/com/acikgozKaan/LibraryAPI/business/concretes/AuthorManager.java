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
    public void update(Author author) {
        Author updatedAuthor = this.getById(author.getId());
        authorRepo.save(updatedAuthor);
    }

    @Override
    public List<Author> getAll() {
        return this.authorRepo.findAll();
    }

    @Override
    public Author getById(Long id) {
        return this.authorRepo.findById(id).orElseThrow(
                ()-> new NotFoundException(Msg.NOT_FOUND)
        );
    }

    @Override
    public void delete(Long id) {
        Author author = this.getById(id);
        this.authorRepo.delete(author);
    }

}
