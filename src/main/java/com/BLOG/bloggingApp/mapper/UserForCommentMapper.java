package com.BLOG.bloggingApp.mapper;

import com.BLOG.bloggingApp.dto.UserDto;
import com.BLOG.bloggingApp.entity.User;

public class UserForCommentMapper {
    /**
     * maps user to userDto
     **/
    public static UserDto mapUserToUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .build();
    }


    /**
     * maps userDto to user
     **/
    public static User mapUserDtoToUser(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .userName(userDto.getUserName())
                .build();
    }
}
