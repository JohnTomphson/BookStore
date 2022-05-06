package com.example.bookstore.controller;

import com.example.bookstore.jwt.JwtProvider;
import com.example.bookstore.models.Userss;
import com.example.bookstore.payload.LoginDTO;
import com.example.bookstore.repository.UserRepo;
import com.example.bookstore.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    private final UserRepo userRepository;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO) {


        Optional<Userss> byUsername = userRepository.findByUsername(loginDTO.getUserName());Map<Object, Object> map = new HashMap<>();

        if (!byUsername.isPresent()) {
            throw new UsernameNotFoundException("Bunday foydalanuvchi mavjud emas");
        } else {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUserName(), loginDTO.getPassword()));

            String s = jwtProvider.generateToken(loginDTO.getUserName());
            map.put("token", s);
            map.put("user", byUsername.get());
            return ResponseEntity.ok(map);
        }

    }


}
