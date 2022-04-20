package com.example.bookstore.repository;

import com.example.bookstore.models.Userss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<Userss,Integer> {
    List<Userss> findAllByActiveTrue();

}
