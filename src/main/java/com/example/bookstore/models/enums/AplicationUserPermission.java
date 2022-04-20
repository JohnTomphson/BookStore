package com.example.bookstore.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
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



}
