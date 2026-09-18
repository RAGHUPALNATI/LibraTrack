package com.raghu.bookapi.controller;


import com.raghu.bookapi.model.Book;
import com.raghu.bookapi.model.Genre;
import com.raghu.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
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
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){

        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> searchBooksByGenre(@PathVariable String genre){
        return ResponseEntity.ok(bookService.searchBooksByGenre(Genre.valueOf(genre.toUpperCase())));
    }
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Book>> searchBooks(@PathVariable String keyword){
        return ResponseEntity.ok(bookService.searchBooks(keyword));

    }
    @GetMapping("/available")
    public ResponseEntity<List<Book>> searchBooksByAvailableTrue(){
        return ResponseEntity.ok(bookService.searchBooksByAvailableTrue());
    }

    @PatchMapping("/{id}/availability")
    public ResponseEntity<Book> toggleAvailability(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.toggleAvailability(id));
    }

}
