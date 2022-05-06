package com.example.bookstore.service.template;

import com.example.bookstore.payload.ApiResponse;

public interface Crud {

    ApiResponse getAll();

    ApiResponse getById(Long id);


    ApiResponse delete(Long id);
}
