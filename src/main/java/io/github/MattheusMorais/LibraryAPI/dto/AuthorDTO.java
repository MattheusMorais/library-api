package io.github.MattheusMorais.LibraryAPI.dto;

import io.github.MattheusMorais.LibraryAPI.model.Author;

import java.time.LocalDate;

public record AuthorDTO(
        String id,
        String name,
        LocalDate birthDate,
        String nationality) {


    public Author mapToEntity() {
        Author authorEntity = new Author();
        authorEntity.setName(this.name);
        authorEntity.setBirthDate(this.birthDate);
        authorEntity.setNationality(this.nationality);
        return authorEntity;
    }
}
