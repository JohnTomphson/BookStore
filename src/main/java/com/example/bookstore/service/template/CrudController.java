package com.example.bookstore.service.template;

import org.springframework.http.ResponseEntity;

public interface CrudController {
    ResponseEntity getAll();

    ResponseEntity getById(Long id);

    ResponseEntity delete(Long id);

}
