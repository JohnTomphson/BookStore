package com.example.bookstore.service.template;

import org.springframework.http.ResponseEntity;

public interface CrudController {
    ResponseEntity getAll();

    ResponseEntity getById(Integer id);

    ResponseEntity delete(Integer id);

}
