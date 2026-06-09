package io.github.MattheusMorais.LibraryAPI.service;

import io.github.MattheusMorais.LibraryAPI.model.Author;
import io.github.MattheusMorais.LibraryAPI.model.Book;
import io.github.MattheusMorais.LibraryAPI.model.BooksGenres;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Test
    void shouldInsertBook() {
        Book book = new Book();
        book.setTitle("Homo Deus");
        book.setGenre(BooksGenres.SCIENCE);
        book.setPrice(BigDecimal.valueOf(50));
        book.setIsbn("978-0-439-02348-1");
        book.setPublishedDate(LocalDate.of(1980,1,2));
        book.setRegisterDate(LocalDateTime.now());

        Author author = authorService.findById(UUID.fromString("f3404786-bbbb-46e2-8880-150c236bea01"));
        book.setAuthor(author);

        Book savedBook = bookService.insert(book);
        System.out.println("Livro salvo: " + savedBook);
    }

//    @Test
//    void shouldUpdateBook() {
//        UUID uuid = UUID.fromString("2b95664a-7926-410c-b6e6-c2a66351f80c");
//        Book book = bookService.findById(uuid);
//
//        book.setBirthDate(LocalDate.of(1960, 1, 30));
//        bookService.update(book);
//    }

    @Test
    void shouldListBooks() {
        List<Book> books = bookService.findAll();
        books.forEach(System.out::println);
    }

    @Test
    void shouldDeleteById() {
        UUID id = UUID.fromString("2449f4e4-ee1a-4a71-8aa3-e9d46306fe8a");
        bookService.delete(id);
    }
}