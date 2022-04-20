package com.example.bookstore.service.template;

import com.example.bookstore.payload.ApiResponse;

public interface Crud {

    ApiResponse getAll();

    ApiResponse getById(Integer id);

    ApiResponse delete(Integer id);
}
