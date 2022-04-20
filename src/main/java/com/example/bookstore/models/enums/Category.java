package com.example.bookstore.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

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

}
