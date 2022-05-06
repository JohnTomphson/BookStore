package com.example.bookstore.service;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.example.bookstore.models.Book;
import com.example.bookstore.models.enums.Category;
import com.example.bookstore.models.enums.Language;
import com.example.bookstore.models.enums.Sinf;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.payload.BookDTO;
import com.example.bookstore.repository.BookRepo;
import com.example.bookstore.service.template.Crud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements Crud {
    final BookRepo bookRepo;


    @Override
    public ApiResponse getAll() {
        List<Book> bookList = bookRepo.findAllByActiveTrue();
        return bookList != null ? new ApiResponse(true, "Success", bookList)
                : new ApiResponse(false, "Failed");
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        return bookOptional.map(orders -> new ApiResponse(true, "Success", orders))
                .orElseGet(() -> new ApiResponse(false, "Not Found"));
    }



    public ApiResponse update(Long id, BookDTO bookDTO) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if (!bookOptional.isPresent())
            return ApiResponse.builder().success(false).message("Not found").build();

        Book book = bookOptional.get();
        if (bookDTO.getLanguageId().equals(1))
            book.setLanguage(Language.UZ);
        else if (bookDTO.getLanguageId().equals(2))
            book.setLanguage(Language.RUS);
        else if (bookDTO.getLanguageId().equals(3))
            book.setLanguage(Language.ENG);
        else if (bookDTO.getLanguageId().equals(4))
            book.setLanguage(Language.QZ);
        else
            return ApiResponse.builder().success(false).message("Language Not Found").build();


        if (bookDTO.getCategoryId().equals(1))
            book.setCategory(Category.BIOLOGIYA);

        else if (bookDTO.getCategoryId().equals(2))
            book.setCategory(Category.FIZIKA);
        else if (bookDTO.getCategoryId().equals(3))
            book.setCategory(Category.ONATILI);
        else if (bookDTO.getCategoryId().equals(4))
            book.setCategory(Category.RUSTIL);
        else if (bookDTO.getCategoryId().equals(5))
            book.setCategory(Category.INGILIZTILI);
        else if (bookDTO.getCategoryId().equals(6))
            book.setCategory(Category.MATEM);
        else if (bookDTO.getCategoryId().equals(7))
            book.setCategory(Category.RASSOMCHILIK);
        else if (bookDTO.getCategoryId().equals(8))
            book.setCategory(Category.GEOGRAFIYA);
        else if (bookDTO.getCategoryId().equals(9))
            book.setCategory(Category.TARBIYA);
        else if (bookDTO.getCategoryId().equals(10))
            book.setCategory(Category.INFORMATIKA);
        else if (bookDTO.getCategoryId().equals(11))
            book.setCategory(Category.HUQUQ);
        else
            return ApiResponse.builder().success(false).message("Category Not Found").build();

        if (bookDTO.getSinfId().equals(1))
            book.setSinf(Sinf.BIRINCHI_SINF);
        else if (bookDTO.getSinfId().equals(2))
            book.setSinf(Sinf.IKKINCHI_SINF);
        else if (bookDTO.getSinfId().equals(3))
            book.setSinf(Sinf.UCHINCI_SINF);
        else if (bookDTO.getSinfId().equals(4))
            book.setSinf(Sinf.TORTINCHI_SINF);
        else if (bookDTO.getSinfId().equals(5))
            book.setSinf(Sinf.BESHINCHI_SINF);
        else if (bookDTO.getSinfId().equals(6))
            book.setSinf(Sinf.OLTINCHI_SINF);
        else if (bookDTO.getSinfId().equals(7))
            book.setSinf(Sinf.YETTINCHI_SINF);
        else if (bookDTO.getSinfId().equals(8))
            book.setSinf(Sinf.SAKKIZINCHI_SINF);
        else if (bookDTO.getSinfId().equals(9))
            book.setSinf(Sinf.TUQQIZINCHI_SINF);
        else if (bookDTO.getSinfId().equals(10))
            book.setSinf(Sinf.UNINCHI_SINF);
        else if (bookDTO.getSinfId().equals(11))
            book.setSinf(Sinf.UNBIRINCHI_SINF);
        else
            return ApiResponse.builder().success(false).message("Class Not Found").build();

        book.setAvtor(bookDTO.getAvtor());
        book.setDiscription(bookDTO.getDescription());
        bookRepo.save(book);

        return new ApiResponse(true, "Updated");

    }

    @Override
    public ApiResponse delete(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (!optionalBook.isPresent())
            return ApiResponse.builder().message("This Book isn't present").success(false).build();

        Book book = optionalBook.get();
        book.setActive(false);

        bookRepo.save(book);
        return new ApiResponse(true, "Deleted");
    }



}
