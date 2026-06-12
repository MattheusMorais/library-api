package io.github.MattheusMorais.LibraryAPI.validator;

import io.github.MattheusMorais.LibraryAPI.exceptions.DeleteException;
import io.github.MattheusMorais.LibraryAPI.exceptions.DuplicateRegisterException;
import io.github.MattheusMorais.LibraryAPI.model.Author;
import io.github.MattheusMorais.LibraryAPI.repository.AuthorRepository;
import io.github.MattheusMorais.LibraryAPI.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AuthorValidator {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public void validateInsert(Author author) {
        boolean exists = authorRepository.existsByNameAndBirthDateAndNationality(
                author.getName(),
                author.getBirthDate(),
                author.getNationality()
        );

        if (exists) {
            throw new DuplicateRegisterException("Autor duplicado!");
        }
    }

    public void validateUpdate(Author author) {
        boolean exists = authorRepository.existsByNameAndBirthDateAndNationalityAndIdNot(
                author.getName(),
                author.getBirthDate(),
                author.getNationality(),
                author.getId()
        );

        if (exists) {
            throw new DuplicateRegisterException("Já existe outro autor com esses dados!");
        }
    }

    public void validateDelete(UUID uuid) {
        boolean existsAuthorWithBook = bookRepository.existsByAuthorId(uuid);

        if(existsAuthorWithBook) {
            throw new DeleteException("Não é possível excluir! Autor possui livros.");
        }

    }


}
