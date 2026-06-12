package io.github.MattheusMorais.LibraryAPI.service;

import io.github.MattheusMorais.LibraryAPI.model.Author;
import io.github.MattheusMorais.LibraryAPI.repository.AuthorRepository;
import io.github.MattheusMorais.LibraryAPI.validator.AuthorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorValidator authorValidator;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorValidator authorValidator) {
        this.authorRepository = authorRepository;
        this.authorValidator = authorValidator;
    }

    public List<Author> findAll(){return authorRepository.findAll();}

    public Author findById(UUID id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author insert(Author author) {
        authorValidator.validateInsert(author);
        return authorRepository.save(author);
    }

    public Author update(Author obj) {
        authorValidator.validateUpdate(obj);

        Author author = findById(obj.getId());
        author.setName(obj.getName());
        author.setNationality(obj.getNationality());
        author.setBirthDate(obj.getBirthDate());
        return authorRepository.save(author);
    }

    public void delete(UUID uuid) {
        Author author = this.findById(uuid);
        authorValidator.validateDelete(uuid);
        authorRepository.delete(author);
    }

    public List<Author> findByNameAndNationality(String name, String nationality) {
        if (name!= null && nationality!= null) {
            return authorRepository.findAll();
        }

        if (name!=null) {
            return authorRepository.findByName(name);
        }

        if (nationality!=null) {
            return authorRepository.findByNationality(nationality);
        }

        return authorRepository.findByNameAndNationality(name, nationality);
    }
}
