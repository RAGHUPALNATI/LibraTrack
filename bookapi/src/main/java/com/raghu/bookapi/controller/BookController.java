package com.raghu.bookapi.controller;


import com.raghu.bookapi.model.Book;
import com.raghu.bookapi.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
        Book saved=bookService.createBook(book);
        return ResponseEntity.status(201).body(saved);
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){

        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){

        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@Valid  @RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){

        return ResponseEntity.ok(bookService.deleteBook(id));
    }

}
