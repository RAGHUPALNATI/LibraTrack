package com.raghu.bookapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title cannot be empty")
    @Column(nullable=false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Genre genre;
    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    @Column(nullable=false)
    private Double price;
    @Builder.Default
    private Boolean available=true;
    @Column(updatable=false)
    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate(){
        createdAt=LocalDateTime.now();
    }




}
