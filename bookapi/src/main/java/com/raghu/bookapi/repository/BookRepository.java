package com.raghu.bookapi.repository;

import com.raghu.bookapi.model.Book;

import com.raghu.bookapi.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<Book,Long> {
        List<Book> findByTitleContaining(String title);
        List<Book> findByGenre(Genre genre);
        List<Book> findByAvailableTrue();
        List<Book> findByTitleContainingOrAuthorContaining(String title, String author);


}
