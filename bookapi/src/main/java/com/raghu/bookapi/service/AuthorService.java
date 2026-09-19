package com.raghu.bookapi.service;

import com.raghu.bookapi.model.Author;
import com.raghu.bookapi.model.Book;
import com.raghu.bookapi.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author createAuthor(Author author){
        if (authorRepository.existsByName(author.getName())) {
            throw new RuntimeException("Author already exists: " + author.getName());
        }
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
        Author existing = getAuthorById(id);
        existing.setName(author.getName());
        existing.setEmail(author.getEmail());
        existing.setBio(author.getBio());
        return authorRepository.save(existing);
    }
    public Author getAuthorById(Long id){
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    public List<Book> getBooksByAuthor(Long id) {
        Author author = getAuthorById(id);
        return author.getBooks();
    }

    public String deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        if (!author.getBooks().isEmpty()) {
            throw new RuntimeException(
                    "Cannot delete author with existing books");
        }
        authorRepository.deleteById(id);
        return "Author deleted successfully";
    }


}
