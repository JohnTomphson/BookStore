package com.example.bookstore.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public enum Language {
    UZ("1"),RUS("2"),ENG("3"),QZ("4");
    private  final String languageId;
}
