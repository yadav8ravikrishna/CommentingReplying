package com.BLOG.bloggingApp.service.implementationService;

import com.BLOG.bloggingApp.entity.Blog;
import com.BLOG.bloggingApp.entity.User;
import com.BLOG.bloggingApp.exception.ResourceNotFoundException;
import com.BLOG.bloggingApp.repository.BlogRepo;
import com.BLOG.bloggingApp.repository.UserRepo;
import com.BLOG.bloggingApp.service.BlogServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BlogServiceImpl implements BlogServiceInterface {
    private final BlogRepo blogRepo;
    private final UserRepo userRepo;

    public BlogServiceImpl(BlogRepo blogRepo,
                           UserRepo userRepo) {
        this.blogRepo = blogRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Blog addABlog(Long userId, Blog blog) throws ResourceNotFoundException {
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent()){
            user.get().getBlogs().add(blog);
            userRepo.save(user.get());
        }else {throw new ResourceNotFoundException("User not Found");
        }
        return blog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Override
    public Set<Blog> getAllBlogsOfAUser(Long userId) throws ResourceNotFoundException {
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent()){
            return user.get().getBlogs();
        }else {throw new ResourceNotFoundException("User not found");}
    }

    @Override
    public Blog editBlog(Blog blog) {
        return null;
    }

    @Override
    public String deleteBLog(Long blogId) throws ResourceNotFoundException {
        Optional<Blog> blog = blogRepo.findById(blogId);
        if (blog.isPresent()){
            blogRepo.deleteById(blogId);
            return "blog deleted";
        }else {throw new ResourceNotFoundException("Blog not Found");}
    }
}
