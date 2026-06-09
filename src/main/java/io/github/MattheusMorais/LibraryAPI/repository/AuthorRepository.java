package io.github.MattheusMorais.LibraryAPI.repository;


import io.github.MattheusMorais.LibraryAPI.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
