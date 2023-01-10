package com.BLOG.bloggingApp.service.implementationService;

import com.BLOG.bloggingApp.dto.UserDto;
import com.BLOG.bloggingApp.entity.Blog;
import com.BLOG.bloggingApp.entity.Comment;
import com.BLOG.bloggingApp.entity.User;
import com.BLOG.bloggingApp.exception.ResourceNotFoundException;
import com.BLOG.bloggingApp.mapper.UserMapper;
import com.BLOG.bloggingApp.repository.UserRepo;
import com.BLOG.bloggingApp.service.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<UserDto> allUsers() {

        List<User> users = userRepo.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : users){
           UserDto userDto= UserMapper.mapUserToUserDto(user);
           userDtoList.add(userDto);
        }
       return  userDtoList;
    }


    @Override
    public UserDto getAUser(Long id) throws ResourceNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            return UserMapper.mapUserToUserDto(user.get());
        }else {throw  new ResourceNotFoundException("User not Found");
        }
    }

    @Override
    public User editAUser(Long id, User user) {
        return null;
    }

    @Override
    public void deleteAUser(Long id) throws ResourceNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            userRepo.deleteById(id);
        }else {throw new ResourceNotFoundException("User not Found");}
    }


}
