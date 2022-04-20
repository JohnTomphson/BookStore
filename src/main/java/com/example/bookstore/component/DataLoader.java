package com.example.bookstore.component;

import com.example.bookstore.models.Book;
import com.example.bookstore.models.Role;
import com.example.bookstore.models.Userss;
import com.example.bookstore.models.enums.*;
import com.example.bookstore.payload.enumLists.Collections;
import com.example.bookstore.repository.BookRepo;
import com.example.bookstore.repository.RoleRepository;
import com.example.bookstore.repository.UserRepo;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    final Collections collections;
    final UserService userService;
    final UserRepo userRepo;
    final RoleRepository roleRepository;
    final BookRepo bookRepo;
    final BookService bookService;
    @Value("${spring.sql.init.mode}")
    String mode;


    @Override
    public void run(String... args) throws Exception {

        if (mode.equals("always")) {

            Role admin = new Role();
            admin.setRoleName(ApplicationUserRole.ADMIN);
            Set<AplicationUserPermission> permissions = ApplicationUserRole.ADMIN.getPermissions();
            admin.setPermissionEnum(permissions);
            roleRepository.save(admin);

            Role super_admin = new Role();
            super_admin.setRoleName(ApplicationUserRole.SUPER_ADMIN);
            Set<AplicationUserPermission> permissionList = ApplicationUserRole.SUPER_ADMIN.getPermissions();
            super_admin.setPermissionEnum(permissionList);
            roleRepository.save(super_admin);
            List<Role> admin1 = new ArrayList<>(Arrays.asList(admin));
            List<Role> superAdmin = new ArrayList<>(Arrays.asList(super_admin));

            Userss userService1 = userService.addForDataloader(
                    "admin123@gmail.com",
                    "admin",
                    "admin2",
                    "admin3",
                    admin1);
            userRepo.save(userService1);

            Userss userss = userService.addForDataloader(
                    "superAdmin@gmail.com",
                    "super",
                    "admin",
                    "admin123",
                    superAdmin);
            userRepo.save(userss);

            Book book1Geografiya = bookService.addForDataloaderBook
                    (Sinf.BESHINCHI_SINF, Category.GEOGRAFIYA,
                            "2010 yili",
                            "Saydullayev",
                            Language.UZ);

            Book book2 = bookService.addForDataloaderBook
                    (Sinf.BESHINCHI_SINF,Category.BIOLOGIYA,
                            "2020",
                            "Teshaboyev",
                            Language.RUS
            );

            bookRepo.save(book1Geografiya);
            bookRepo.save(book2);

        }
    }
}
