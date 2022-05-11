package com.example.bookstore.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class BookDTO {
    private String description;
    private String avtor;
    private Integer sinfId;
    private Integer categoryId;
    private Integer languageId;
    private Long attachmentId;
}
