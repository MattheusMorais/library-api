package io.github.MattheusMorais.LibraryAPI.dto;

import io.github.MattheusMorais.LibraryAPI.model.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AuthorDTO(
        String id,
        @NotBlank(message = "Campo obrigatório")
        @Size(min = 2, max = 100, message = "Campo fora do tamanho padrao")
        String name,
        @NotNull(message = "Campo obrigatório")
        @Past(message = "Data nao pode ser uma data futura")
        LocalDate birthDate,
        @NotBlank(message = "Campo obrigatório")
        @Size(min = 2, max = 50, message = "Campo fora do tamanho padrao")
        String nationality) {


    public Author mapToEntity() {
        Author authorEntity = new Author();
        authorEntity.setName(this.name);
        authorEntity.setBirthDate(this.birthDate);
        authorEntity.setNationality(this.nationality);
        return authorEntity;
    }
}
