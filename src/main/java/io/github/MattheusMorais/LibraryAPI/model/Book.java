package io.github.MattheusMorais.LibraryAPI.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "published_data", nullable = false)
    private LocalDateTime published_data;

    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private BooksGenres genre;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "register_date")
    private LocalDateTime register_date;

    @Column(name = "update_date")
    private LocalDateTime update_date;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    @Deprecated
    public Book() {
    }

    @Autowired
    public Book(String isbn, String title, LocalDateTime published_data, BooksGenres genre, BigDecimal price, LocalDateTime register_date, LocalDateTime update_date) {
        this.isbn = isbn;
        this.title = title;
        this.published_data = published_data;
        this.genre = genre;
        this.price = price;
        this.register_date = register_date;
        this.update_date = update_date;
    }
}
