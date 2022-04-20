package com.example.bookstore.controller;

import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.payload.BookDTO;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.template.CrudController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController implements CrudController {
    final BookService bookService;

    @GetMapping
    @Override
    public ResponseEntity getAll() {
        ApiResponse apiResponse = bookService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity getById(@PathVariable Integer id) {
        ApiResponse apiResponse = bookService.getById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

//    @PreAuthorize("hasRole(ApplicationUserRole.ADMIN)")
    @PostMapping
    public ResponseEntity add(@RequestBody BookDTO bookDTO) {
        ApiResponse apiResponse = bookService.add(bookDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

//    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        ApiResponse apiResponse = bookService.update(id, bookDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 404).body(apiResponse);
    }

//    @PreAuthorize("hasRole('Super_Admin')")
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity delete(Integer id) {
        ApiResponse apiResponse = bookService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 204 : 409).body(apiResponse);
    }
}
