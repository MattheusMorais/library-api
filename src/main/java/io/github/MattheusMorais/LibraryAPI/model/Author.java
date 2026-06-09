package io.github.MattheusMorais.LibraryAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="author", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author {
    @Id
    @GeneratedValue
    @Column(name="id")
    private UUID id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "nationality", length = 50, nullable = false)
    private String nationality;

    @Column(name = "post_date")
    private LocalDateTime postDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public Author(String name, LocalDate birthDate, String nationality, LocalDateTime postDate, LocalDateTime updateDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.postDate = postDate;
        this.updateDate = updateDate;
    }
}
