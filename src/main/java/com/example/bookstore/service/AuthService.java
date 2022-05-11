package com.example.bookstore.service;

import com.example.bookstore.models.Role;
import com.example.bookstore.models.Userss;
import com.example.bookstore.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
    public Userss addForDataloader(
            String userName,
            String password,
            String firstName, String middleName,
            String lastName, List<Role> roleList) {

        Userss users = new Userss();
        users.setUsername(userName);
        users.setPassword(password);
        users.setFirstName(firstName);
        users.setMiddleName(middleName);
        users.setLastName(lastName);
        users.setRoleList(roleList);
        return users;
    }

}
