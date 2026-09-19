package com.raghu.bookapi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    @Column(nullable=false)
    private String name;
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Must be a valid email")
    @Column(nullable=false)
    private String email;
    @Column(nullable=true)
    private String bio;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Book> books = new ArrayList<>();


}
