package com.BLOG.bloggingApp.service;

import com.BLOG.bloggingApp.dto.UserDto;
import com.BLOG.bloggingApp.entity.Blog;
import com.BLOG.bloggingApp.entity.User;
import com.BLOG.bloggingApp.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface BlogServiceInterface {
    public Blog addABlog(Long userId,Blog blog) throws ResourceNotFoundException;
    public List<Blog> getAllBlogs();
    Set<Blog> getAllBlogsOfAUser(Long userId) throws ResourceNotFoundException;
    public Blog editBlog(Blog blog);
    public String deleteBLog(Long blogId) throws ResourceNotFoundException;
}
