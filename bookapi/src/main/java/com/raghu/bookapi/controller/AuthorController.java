package com.raghu.bookapi.controller;


import com.raghu.bookapi.model.Author;
import com.raghu.bookapi.model.Book;
import com.raghu.bookapi.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
        Author saved=authorService.createAuthor(author);

        return  ResponseEntity.status(201).body(saved);

    }


    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor( @PathVariable Long id,@Valid @RequestBody Author author){
        return ResponseEntity.ok(authorService.updateAuthor(id, author));
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable Long id){
        return ResponseEntity.ok(authorService.getBooksByAuthor(id));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id){
        return ResponseEntity.ok(authorService.deleteAuthor(id));
    }




}
