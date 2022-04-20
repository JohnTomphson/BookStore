package com.example.bookstore.models.enums;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
@AllArgsConstructor
@Getter
@ToString
public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(AplicationUserPermission.READ_BOOK,
                         AplicationUserPermission.UPDATE_BOOK,
                         AplicationUserPermission.CREATE_BOOK)),
    SUPER_ADMIN(Sets.newHashSet(AplicationUserPermission.READ_BOOK,AplicationUserPermission.DELETE_BOOK));
    private Set<AplicationUserPermission> permissions;


}
