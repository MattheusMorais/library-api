package io.github.MattheusMorais.LibraryAPI.repository;


import io.github.MattheusMorais.LibraryAPI.model.Author;
import io.github.MattheusMorais.LibraryAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    List<Author> findByNameAndNationality(String name, String nationality);

    List<Author> findByName(String name);

    List<Author> findByNationality(String nationality);

    boolean existsByNameAndBirthDateAndNationality(String name, LocalDate birthDate, String nationality);

    boolean existsByNameAndBirthDateAndNationalityAndIdNot(String name, LocalDate birthDate, String nationality, UUID id);

}
