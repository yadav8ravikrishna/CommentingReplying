package com.BLOG.bloggingApp.service;

import com.BLOG.bloggingApp.dto.UserDto;
import com.BLOG.bloggingApp.entity.User;
import com.BLOG.bloggingApp.exception.ResourceNotFoundException;

import java.util.List;

public interface UserServiceInterface {
    User addUser(User user);
    List<UserDto> allUsers();
    User getAUser(Long id) throws ResourceNotFoundException;
    User editAUser(Long id,User user);
    void deleteAUser(Long id) throws ResourceNotFoundException;
}
