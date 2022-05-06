package com.example.bookstore.repository;

import com.example.bookstore.models.Userss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<Userss,Long> {
    List<Userss> findAllByActiveTrue();
Optional<Userss> findByUsername(String username);
}
