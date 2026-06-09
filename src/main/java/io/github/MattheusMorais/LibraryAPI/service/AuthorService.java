package io.github.MattheusMorais.LibraryAPI.service;

import io.github.MattheusMorais.LibraryAPI.model.Author;
import io.github.MattheusMorais.LibraryAPI.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll(){return authorRepository.findAll();}

    public Author findById(UUID id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author insert(Author author){return authorRepository.save(author);}

    public Author update(Author obj){
        Author author = findById(obj.getId());
        author.setName(obj.getName());
        author.setNationality(obj.getNationality());
        author.setBirthDate(obj.getBirthDate());
        return authorRepository.save(author);
    }

    public void delete(UUID uuid) {authorRepository.deleteById(uuid);}
}
