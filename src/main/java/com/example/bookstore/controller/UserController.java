package com.example.bookstore.controller;

import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.UserService;
import com.example.bookstore.service.template.CrudController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController implements CrudController {
    final UserService userService;

//    @PreAuthorize("hasRole('Admin')")
    @GetMapping
    @Override
    public ResponseEntity getAll() {
        ApiResponse apiResponse = userService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

//    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity getById(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.getById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }
//
//    @PostMapping("/{id}")
//    public ResponseEntity add(@RequestBody Userss user) {
//        ApiResponse apiResponse = userService.add(user);
//        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
//    }
//
//

    /**
     * We do not use this method temporarily
     * @param id
     * @return
     */
    @Override
    public ResponseEntity delete(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 204 : 409).body(apiResponse);
    }
}
