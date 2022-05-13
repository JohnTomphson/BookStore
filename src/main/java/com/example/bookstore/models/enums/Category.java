package com.example.bookstore.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public enum Category {
    BIOLOGIYA("1"),
    FIZIKA("2"),
    ONATILI("3"),
    RUSTIL("4"),
    INGILIZTILI("5"),
    MATEM("6"),
    RASSOMCHILIK("7"),
    GEOGRAFIYA("8"),
    TARBIYA("9"),
    INFORMATIKA("10"),
    HUQUQ("11");

    private final String categoryId;

    /**
     *
     * @return
     */
    @Bean
    public List<Category> categoryListList() {
        List<Category> categoryList = new ArrayList<Category>(
                Arrays.asList(Category.BIOLOGIYA,Category.FIZIKA,Category.GEOGRAFIYA,
                        Category.MATEM,Category.INFORMATIKA,Category.TARBIYA,Category.ONATILI,
                        Category.RASSOMCHILIK,Category.RUSTIL));
        return categoryList;
    }

}
