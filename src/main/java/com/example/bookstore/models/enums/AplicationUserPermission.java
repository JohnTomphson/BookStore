package com.example.bookstore.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@ToString
public enum AplicationUserPermission {
    CREATE_BOOK("create:book"),
    READ_BOOK("read:book"),
    DELETE_BOOK("delete:book"),
    UPDATE_BOOK("update:book");
//    READ_CLASS("read: class");
    private final String permissions;


    @Bean
    public Set<AplicationUserPermission> applicationUserPermission() {
        Set<AplicationUserPermission> roleList = new HashSet<AplicationUserPermission>(
                Arrays.asList(
                        AplicationUserPermission.CREATE_BOOK,AplicationUserPermission.DELETE_BOOK,
                        AplicationUserPermission.UPDATE_BOOK,AplicationUserPermission.READ_BOOK));
        return roleList;
    }

}
