package io.github.MattheusMorais.LibraryAPI.service;

import io.github.MattheusMorais.LibraryAPI.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    void shouldInsertAuthor() {
        Author author = new Author();
        author.setName("Maria");
        author.setNationality("Brazil");
        author.setBirthDate(LocalDate.of(1951, 1, 31));

        Author savedAuthor = authorService.insert(author);
        System.out.println("Autor salvo: " + savedAuthor);
    }

    @Test
    void shouldUpdateAuthor() {
        UUID uuid = UUID.fromString("2b95664a-7926-410c-b6e6-c2a66351f80c");
        Author author = authorService.findById(uuid);

        author.setBirthDate(LocalDate.of(1960, 1, 30));
        authorService.update(author);
    }

    @Test
    void shouldListAuthors() {
        List<Author> authors = authorService.findAll();
        authors.forEach(System.out::println);
    }

    @Test
    void shouldDeleteById() {
        UUID id = UUID.fromString("2449f4e4-ee1a-4a71-8aa3-e9d46306fe8a");
        authorService.delete(id);
    }
}
