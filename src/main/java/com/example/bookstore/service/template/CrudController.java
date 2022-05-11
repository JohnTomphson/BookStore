package com.example.bookstore.service.template;

import org.springframework.http.ResponseEntity;

public interface CrudController {
    ResponseEntity getAll();

    ResponseEntity getInfoBookById(Long id);
    ResponseEntity getFileById(Long id);

    ResponseEntity delete(Long id);

}
