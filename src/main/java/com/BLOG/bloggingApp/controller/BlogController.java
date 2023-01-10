package com.BLOG.bloggingApp.controller;

import com.BLOG.bloggingApp.entity.Blog;
import com.BLOG.bloggingApp.exception.ResourceNotFoundException;
import com.BLOG.bloggingApp.service.BlogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServiceInterface blogServiceInterface;

    @GetMapping
    public List<Blog> blogs(){
        return blogServiceInterface.getAllBlogs();
    }

    @GetMapping("usersBlog/{userId}")
    public Set<Blog> usersAllBlog(@PathVariable Long userId) throws ResourceNotFoundException {
        return blogServiceInterface.getAllBlogsOfAUser(userId);
    }
    @PostMapping("/{userId}")
    public Blog addBlog(@PathVariable Long userId, @RequestBody Blog blog) throws ResourceNotFoundException {
        return blogServiceInterface.addABlog(userId,blog);
    }
}
