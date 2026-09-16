package com.raghu.bookapi.service;

import com.raghu.bookapi.model.Book;
import com.raghu.bookapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public Book updateBook(Long id,Book updatedBook){
        Book existing = getBookById(id);
        existing.setTitle(updatedBook.getTitle());
        existing.setAuthor(updatedBook.getAuthor());
        existing.setGenre(updatedBook.getGenre());
        existing.setPrice(updatedBook.getPrice());
        existing.setAvailable(updatedBook.getAvailable());
        return bookRepository.save(existing);

    }
    public String deleteBook(Long id){
        Book existing = getBookById(id); // confirm it exists first
        bookRepository.deleteById(id);
        return "Book deleted successfully";

    }
}
