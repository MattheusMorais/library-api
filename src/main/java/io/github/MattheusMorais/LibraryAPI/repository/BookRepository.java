package io.github.MattheusMorais.LibraryAPI.repository;

import io.github.MattheusMorais.LibraryAPI.model.Author;
import io.github.MattheusMorais.LibraryAPI.model.Book;
import io.github.MattheusMorais.LibraryAPI.model.BooksGenres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
//Query Methods

    // SELECT * FROM Book WHERE author_id = id
    List<Book> findByAuthor(Author author);

    // SELECT * FROM Book WHERE title = title
    Book findByTitle(String title);

    // SELECT * FROM Book WHERE genre = genre
    List<Book> findByGenre(BooksGenres genre);

    // SELECT * FROM Book WHERE title = ? and price = ?
    List<Book> findByTitleAndPrice(String title, BigDecimal price);

    // SELECT * FROM Book WHERE published_date between ? and ?
    List<Book> findByPublishedDateBetween(LocalDate start, LocalDate end);

    // JPQL -> referencia as entidades e as propriedades
    // select l.* from livro as l order by l.title
    @Query(" select l from Book as l order by l.title, l.price ")
    List<Book> listarTodosOrdenadoPorTituloAndPreco();

    /**
     * select a.*
     * from livro l
     * join author a on a.id = l.id_author
     */
    @Query("select a from Book l join l.author a ")
    List<Author> listBooksAuthor();

    // select distinct l.* from livro l
    @Query("select distinct l.title from Book l")
    List<String> listDifferentsBooksNames();

    // named parameters -> parametros nomeados
    @Query("select l from Book l where l.genre = :genre order by :paramOrdenacao ")
    List<Book> findByGenre(
            @Param("genre") BooksGenres genre,
            @Param("paramOrdenacao") String propertyName
    );

    // positional parameters
    @Query("select l from Book l where l.genre = ?2 order by ?1 ")
    List<Book> findByGenrePositionalParameters(String propertyName, BooksGenres genre);

    @Modifying
    @Transactional
    @Query(" delete from Book where genre = ?1 ")
    void deleteByGenre(BooksGenres genre);

    @Modifying
    @Transactional
    @Query(" update Book set publishedDate = ?1 ")
    void updatePublishedDate(LocalDate newDate);


}
