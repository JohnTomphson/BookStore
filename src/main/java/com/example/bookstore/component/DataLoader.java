package com.example.bookstore.component;

import com.example.bookstore.models.Role;
import com.example.bookstore.models.Userss;
import com.example.bookstore.models.enums.*;
import com.example.bookstore.repository.BookRepo;
import com.example.bookstore.repository.RoleRepository;
import com.example.bookstore.repository.UserRepo;
import com.example.bookstore.service.AuthService;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    final PasswordEncoder passwordEncoder;

    final AuthService authService;
    final UserRepo userRepo;
    final RoleRepository roleRepository;
    final BookRepo bookRepo;
    final BookService bookService;


    /**
     *
     */
    @Value("${spring.sql.init.mode}")
    String mode;


    /**
     *
     * @param args
     */
    @Override
    public void run(String... args){

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

            Role user = new Role();
            user.setRoleName(ApplicationUserRole.SUPER_ADMIN);
            Set<AplicationUserPermission> permissionListUser = ApplicationUserRole.USER.getPermissions();
            user.setPermissionEnum(permissionListUser);
            roleRepository.save(user);


            List<Role> admin1 = new ArrayList<>(Arrays.asList(admin));
            List<Role> superAdmin = new ArrayList<>(Arrays.asList(super_admin));
            List<Role> userList = new ArrayList<>(Arrays.asList(user));

            Userss userService1 = authService.addForDataloader(
                    "admin123@gmail.com",
                    passwordEncoder.encode( "123"),
                    "admin",
                    "admin2",
                    "admin3",
                    admin1);
            userRepo.save(userService1);

            Userss userss = authService.addForDataloader(
                    "superAdmin@gmail.com",
                    passwordEncoder.encode( "root1234"),
                    "super",
                    "admin",
                    "admin123",
                    superAdmin);
            userRepo.save(userss);

            Userss user1 = authService.addForDataloader(
                    "user@gmail.com",
                    passwordEncoder.encode( "simpleUser"),
                    "user",
                    "user2",
                    "user3",
                    userList);
            userRepo.save(user1);

        }
    }
}
