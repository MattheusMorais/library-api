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
import java.util.List;
import java.util.UUID;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Test
    void shouldInsertBookWithoutCascade() {
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

    @Test
    void shouldInsertAuthorAndBookWithoutCascade(){
            Book book = new Book();
            book.setTitle("Homo Deus");
            book.setGenre(BooksGenres.SCIENCE);
            book.setPrice(BigDecimal.valueOf(50));
            book.setIsbn("978-0-439-02348-3");
            book.setPublishedDate(LocalDate.of(1980,1,2));
            book.setRegisterDate(LocalDateTime.now());

            Author author = new Author();
            author.setName("Maria");
            author.setNationality("Brazil");
            author.setBirthDate(LocalDate.of(1951, 1, 31));

            authorService.insert(author);
            book.setAuthor(author);

            bookService.insert(book);
    }

    @Test
    void shouldInsertAuthorAndBookCascade() {
        Book book = new Book();
        book.setTitle("Homo Deus");
        book.setGenre(BooksGenres.SCIENCE);
        book.setPrice(BigDecimal.valueOf(50));
        book.setIsbn("978-0-439-02348-1");
        book.setPublishedDate(LocalDate.of(1980,1,2));
        book.setRegisterDate(LocalDateTime.now());

        Author author = new Author();
        author.setName("Maria");
        author.setNationality("Brazil");
        author.setBirthDate(LocalDate.of(1951, 1, 31));

//        authorService.insert(author); Não precisa salvar antes, pois está em cascade, ao salvar o livro salva o author
        // Cascade é bem arriscado, quase não é usado em produção
        book.setAuthor(author);

        bookService.insert(book);
    }

    @Test
    void shouldUpdateBookAuthor(){
        UUID id = UUID.fromString("cfbc87ce-5932-4792-bff0-78ef5973861b");
        Book updatedBook = bookService.findById(id);

        UUID idAutor = UUID.fromString("76e7c418-ccf9-4e2a-af20-c28b9e50ab55");
        Author maria = authorService.findById(idAutor);

        updatedBook.setAuthor(maria);

        bookService.insert(updatedBook);
    }

    @Test
    @Transactional
    void shouldFindBook() {
        UUID id = UUID.fromString("dacd9b52-172a-4c7e-97d4-e3b1cac09452");
        Book book = bookService.findById(id);
        System.out.println("book:");
        System.out.println(book.getTitle());

        System.out.println("Autor:");
        System.out.println(book.getAuthor().getName());
    }

    @Test
    void shouldFindByAuthor() {
        var id = UUID.fromString("c161ade6-6a8e-42fd-b241-12ed3638d14c");
        var author = authorService.findById(id);

        List<Book> booksList = bookService.findBooksByAuthor(author);
        author.setBooks(booksList);

        author.getBooks().forEach(System.out::println);
    }

    @Test
    void shouldDeleteById() {
        UUID id = UUID.fromString("2449f4e4-ee1a-4a71-8aa3-e9d46306fe8a");
        bookService.delete(id);
    }
}