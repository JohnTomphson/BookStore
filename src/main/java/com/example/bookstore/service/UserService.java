package com.example.bookstore.service;

import com.example.bookstore.models.Role;
import com.example.bookstore.models.Userss;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.repository.UserRepo;
import com.example.bookstore.service.template.Crud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements Crud {

    final UserRepo userRepo;

    /**
     * Method that gets all Users which are active true
     *
     * @return ApiResponse
     */
    @Override
    public ApiResponse getAll() {
        List<Userss> userProList = userRepo.findAllByActiveTrue();
        return userProList != null ? new ApiResponse(true, "Success", userProList)
                : new ApiResponse(false, "Failed");
    }

    @Override
    public ApiResponse getById(Integer id) {
        Optional<Userss> usersOptional = userRepo.findById(id);
        return usersOptional.map(orders -> new ApiResponse(true, "Success", orders))
                .orElseGet(() -> new ApiResponse(false, "Not Found"));
    }


    public ApiResponse add(Userss user) {
        userRepo.save(user);
        return new ApiResponse(false, "added");
    }

    @Override
    public ApiResponse delete(Integer id) {
        Optional<Userss> optionalUsers = userRepo.findById(id);
        if (!optionalUsers.isPresent())
            return ApiResponse.builder().message("This User isn't present").success(false).build();
        Userss oldusers = optionalUsers.get();

        oldusers.setActive(false);

        userRepo.save(oldusers);
        return new ApiResponse(true, "Deleted");
    }

    public Userss addForDataloader(
            String userName,
            String firstName, String middleName,
            String lastName, List<Role> roleList) {

        Userss users = new Userss();
        users.setName(userName);
        users.setFirstName(firstName);
        users.setMiddleName(middleName);
        users.setLastName(lastName);
        users.setRoleList(roleList);
        return users;
    }

}
