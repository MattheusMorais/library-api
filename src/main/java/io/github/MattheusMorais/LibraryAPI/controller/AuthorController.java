package io.github.MattheusMorais.LibraryAPI.controller;


import io.github.MattheusMorais.LibraryAPI.dto.AuthorDTO;
import io.github.MattheusMorais.LibraryAPI.dto.error.AnswerErrorDTO;
import io.github.MattheusMorais.LibraryAPI.exceptions.DeleteException;
import io.github.MattheusMorais.LibraryAPI.exceptions.DuplicateRegisterException;
import io.github.MattheusMorais.LibraryAPI.model.Author;
import io.github.MattheusMorais.LibraryAPI.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody AuthorDTO authorDTO) {
        try {
            Author authorEntity = authorDTO.mapToEntity();
            authorService.insert(authorEntity);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(authorEntity.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (DuplicateRegisterException e) {
            var errorDTO = AnswerErrorDTO.standardAnswer(e.getMessage());
            return ResponseEntity.status(errorDTO.status()).body(errorDTO);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> findAuthor(@PathVariable String id) {
        Author authorEntity = authorService.findById(UUID.fromString(id));

        AuthorDTO authorDTO = new AuthorDTO(
                authorEntity.getId().toString(),
                authorEntity.getName(),
                authorEntity.getBirthDate(),
                authorEntity.getNationality());

        return ResponseEntity.ok(authorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable String id, @RequestBody AuthorDTO authorDTO) {
        try {
            Author authorToUpdate = authorService.findById(UUID.fromString(id));
            authorToUpdate.setName(authorDTO.name());
            authorToUpdate.setBirthDate(authorDTO.birthDate());
            authorToUpdate.setNationality(authorDTO.nationality());

            return ResponseEntity.noContent().build();
        } catch (DuplicateRegisterException e) {
            var errorDTO = AnswerErrorDTO.conflictAnswer(e.getMessage());
            return ResponseEntity.status(errorDTO.status()).body(errorDTO);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable String id) {
        try{
        authorService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
        }catch (DeleteException e) {
            var errorDTO = AnswerErrorDTO.standardAnswer(e.getMessage());
            return ResponseEntity.status(errorDTO.status()).body(errorDTO);
        }
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> findByNameAndNationality(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "nationality", required = false) String nationality) {
                List<AuthorDTO> list = authorService.findByNameAndNationality(name, nationality)
                        .stream()
                        .map(author -> new AuthorDTO(
                                author.getId().toString(),
                                author.getName(),
                                author.getBirthDate(),
                                author.getNationality()
                        ))
                        .toList();
                return ResponseEntity.ok(list);
    }

}
