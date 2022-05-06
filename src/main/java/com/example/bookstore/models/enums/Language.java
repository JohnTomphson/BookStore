package com.example.bookstore.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@ToString
@Getter
public enum Language {
    UZ("1"),RUS("2"),ENG("3"),QZ("4");
    private  final String languageId;
    @Bean
    public List<Language> languageList() {
        List<Language> languageList = new ArrayList<Language>
                (Arrays.asList(Language.ENG,Language.QZ, Language.RUS,Language.UZ));
        return languageList;
    }

}
