package io.github.MattheusMorais.LibraryAPI.repository;

import io.github.MattheusMorais.LibraryAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
