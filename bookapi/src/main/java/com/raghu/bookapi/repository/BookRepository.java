package com.raghu.bookapi.repository;

import com.raghu.bookapi.model.Book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepository extends JpaRepository<Book,Long> {


}
