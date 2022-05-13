package com.example.bookstore.models;

import com.example.bookstore.models.enums.Category;
import com.example.bookstore.models.enums.Language;
import com.example.bookstore.models.enums.Sinf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne
    Attachment attachment;

    private boolean active = true;
}
