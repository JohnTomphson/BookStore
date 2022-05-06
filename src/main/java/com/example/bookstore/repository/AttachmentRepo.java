package com.example.bookstore.repository;

import com.example.bookstore.models.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentRepo extends JpaRepository<Attachment,Long> {


}
