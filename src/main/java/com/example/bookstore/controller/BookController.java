package com.example.bookstore.controller;

import com.example.bookstore.models.Attachment;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.payload.BookDTO;
import com.example.bookstore.repository.AttachmentRepo;
import com.example.bookstore.repository.BookRepo;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.template.CrudController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController implements CrudController {
    final BookService bookService;
    final AttachmentRepo attachmentRepo;

    final BookRepo bookRepo;


    @Override
    @GetMapping
    public ResponseEntity getAll() {
        ApiResponse apiResponse = bookService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity getInfoBookById(Long id) {
        ApiResponse apiResponse = bookService.getById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }


    @Override
    @GetMapping("/file/{id}")
    public ResponseEntity getFileById(@PathVariable Long id) {
        Optional<Attachment> byId = attachmentRepo.findById(id);
        Attachment attechment = byId.get();
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(attechment.getContenType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "file")
                .body(attechment.getBytes());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/upload/file")
    public Long saveFile(MultipartHttpServletRequest request) throws IOException {
        MultipartFile file = request.getFile("ketmon");

        Attachment attechment = null;
        if (file != null || !file.isEmpty()) {
            if (file.getContentType().equals("application/pdf")) {

                Attachment attechment1 = new Attachment();
                attechment1.setContenType(file.getContentType());
                attechment1.setName(file.getOriginalFilename());
                attechment1.setSize(file.getSize());
                attechment1.setBytes(file.getBytes());
                attechment = attachmentRepo.save(attechment1);

            }


        }
        return attechment.getId();
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/info")
    public ResponseEntity addBookInfo(@RequestBody BookDTO bookDTO) {
        ApiResponse apiResponse = bookService.add(bookDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity updateInfo(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        ApiResponse apiResponse = bookService.update(id, bookDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }

    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ApiResponse apiResponse = bookService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 204 : 409).body(apiResponse);
    }
}
