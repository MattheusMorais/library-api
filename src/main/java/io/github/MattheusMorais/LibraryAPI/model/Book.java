package io.github.MattheusMorais.LibraryAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "published_date", nullable = false)
    private LocalDate publishedDate;

    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private BooksGenres genre;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @ManyToOne(
//            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name="author_id", nullable = false)
    private Author author;

    public Book(String isbn, String title, LocalDate publishedDate, BooksGenres genre, BigDecimal price, LocalDateTime registerDate, LocalDateTime updateDate) {
        this.isbn = isbn;
        this.title = title;
        this.publishedDate = publishedDate;
        this.genre = genre;
        this.price = price;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
    }
}
