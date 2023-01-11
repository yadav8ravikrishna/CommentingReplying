package com.BLOG.bloggingApp.mapper;

import com.BLOG.bloggingApp.dto.BlogDto;
import com.BLOG.bloggingApp.dto.UserDto;
import com.BLOG.bloggingApp.entity.Blog;
import com.BLOG.bloggingApp.entity.User;

import java.util.HashSet;
import java.util.Set;

public class UserMapper {

    /**
     * maps user to userDto
     **/
    public static UserDto mapUserToUserDto(User user){
        UserDto userdto=UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .build();

        Set<Blog> blogs=user.getBlogs();
        Set<BlogDto> blogDtoList = new HashSet<>();
        for (Blog blog:blogs) {
            BlogDto blg= BlogMapper.mapBlogToBlogDto(blog);
            blogDtoList.add(blg);



        }

        userdto.setBlogs(blogDtoList);
        return userdto;
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
