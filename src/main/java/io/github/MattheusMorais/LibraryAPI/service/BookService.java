package io.github.MattheusMorais.LibraryAPI.service;

import io.github.MattheusMorais.LibraryAPI.model.Book;
import io.github.MattheusMorais.LibraryAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){return bookRepository.findAll();}

    public Book findById(UUID id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book insert(Book book){return bookRepository.save(book);}

    public Book update(Book obj){
        Book book = findById(obj.getId());
        book.setIsbn(obj.getIsbn());
        book.setAuthor(obj.getAuthor());
        book.setPrice(obj.getPrice());
        book.setGenre(obj.getGenre());
        book.setTitle(obj.getTitle());
        book.setPublishedDate(obj.getPublishedDate());

        return bookRepository.save(book);
    }

    public void delete(UUID uuid) {bookRepository.deleteById(uuid);}
}
