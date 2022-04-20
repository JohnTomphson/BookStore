package com.example.bookstore.models;

import com.example.bookstore.models.enums.Category;
import com.example.bookstore.models.enums.Language;
import com.example.bookstore.models.enums.Sinf;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Sinf sinf;


    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String discription;

    @Column(nullable = false)
    private String avtor;

    @Enumerated(EnumType.STRING)
    private Language language;

    private boolean active = true;
}
