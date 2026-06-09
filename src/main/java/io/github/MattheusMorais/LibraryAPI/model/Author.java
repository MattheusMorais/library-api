package io.github.MattheusMorais.LibraryAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="author", schema = "public")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private UUID id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birth_date;

    @Column(name = "nationality", length = 50, nullable = false)
    private String nationality;

    @Column(name = "post_date")
    private LocalDateTime post_date;

    @Column(name = "update_date")
    private LocalDateTime update_date;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    @Deprecated
    public Author() {
    }

    public Author(String name, LocalDate birth_date, String nationality, LocalDateTime post_date, LocalDateTime update_date) {
        this.name = name;
        this.birth_date = birth_date;
        this.nationality = nationality;
        this.post_date = post_date;
        this.update_date = update_date;
    }
}
