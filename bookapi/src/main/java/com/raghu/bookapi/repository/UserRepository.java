package com.raghu.bookapi.repository;


import com.raghu.bookapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);


    boolean existsByName(String name);

    boolean existsByEmail(String email);
}
