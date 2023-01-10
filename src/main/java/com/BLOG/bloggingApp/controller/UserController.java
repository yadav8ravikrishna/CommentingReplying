package com.BLOG.bloggingApp.controller;

import com.BLOG.bloggingApp.dto.UserDto;
import com.BLOG.bloggingApp.entity.User;
import com.BLOG.bloggingApp.exception.ResourceNotFoundException;
import com.BLOG.bloggingApp.repository.UserRepo;
import com.BLOG.bloggingApp.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceInterface userServiceInterface;
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @GetMapping
    public List<UserDto> getAllUsers(){
        return userServiceInterface.allUsers();
    }

    @GetMapping("/getAUser/{userId}")
    public UserDto getAUser(@PathVariable Long userId) throws ResourceNotFoundException {
        return userServiceInterface.getAUser(userId);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userServiceInterface.addUser(user);
    }
    @DeleteMapping("deleteUser/{userId}")
    public void deleteUser(@PathVariable Long id) throws ResourceNotFoundException {
        userServiceInterface.deleteAUser(id);
    }

}
