package io.github.MattheusMorais.LibraryAPI.service;

import io.github.MattheusMorais.LibraryAPI.model.Author;
import io.github.MattheusMorais.LibraryAPI.model.Book;
import io.github.MattheusMorais.LibraryAPI.model.BooksGenres;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Autowired BookService bookService;

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
    void shouldInsertAuthorWithBook() {
        Author author = new Author();
        author.setName("George R.R. Martin");
        author.setNationality("Americano");
        author.setBirthDate(LocalDate.of(1961, 1, 31));

        Book book1 = new Book();
        book1.setTitle("A fúria dos Reis");
        book1.setGenre(BooksGenres.FANTASY);
        book1.setPrice(BigDecimal.valueOf(50));
        book1.setIsbn("978-0-439-02148-2");
        book1.setPublishedDate(LocalDate.of(1998,4,2));
        book1.setRegisterDate(LocalDateTime.now());
        book1.setAuthor(author);

        Book book2 = new Book();
        book2.setTitle("A Tormenta de Espadas");
        book2.setGenre(BooksGenres.FANTASY);
        book2.setPrice(BigDecimal.valueOf(50));
        book2.setIsbn("978-0-439-04348-3");
        book2.setPublishedDate(LocalDate.of(2002,1,5));
        book2.setRegisterDate(LocalDateTime.now());
        book2.setAuthor(author);

        author.setBooks(new ArrayList<>());
        author.getBooks().add(book1);
        author.getBooks().add(book2);

        authorService.insert(author);
        bookService.insert(book1);
        bookService.insert(book2);
    }


    @Test
    void shouldUpdateAuthor() {
        UUID uuid = UUID.fromString("2b95664a-7926-410c-b6e6-c2a66351f80c");
        Author author = authorService.findById(uuid);

        author.setBirthDate(LocalDate.of(1960, 1, 30));
        authorService.update(author);
    }

    @Test
    @Transactional
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
