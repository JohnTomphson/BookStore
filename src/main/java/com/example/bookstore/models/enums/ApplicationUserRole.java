package com.example.bookstore.models.enums;

import com.google.common.collect.Sets;
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
public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(AplicationUserPermission.READ_BOOK,
                         AplicationUserPermission.UPDATE_BOOK,
                         AplicationUserPermission.CREATE_BOOK)),
    SUPER_ADMIN(Sets.newHashSet(AplicationUserPermission.READ_BOOK,AplicationUserPermission.DELETE_BOOK));
    private Set<AplicationUserPermission> permissions;


    @Bean
    public Set<ApplicationUserRole> applicationUserRoles() {
        Set<ApplicationUserRole> roleList = new HashSet<ApplicationUserRole>(
                Arrays.asList(
                        ApplicationUserRole.SUPER_ADMIN,ApplicationUserRole.ADMIN));
        return roleList;
    }
}
