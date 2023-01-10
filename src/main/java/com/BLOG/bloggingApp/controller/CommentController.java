package com.BLOG.bloggingApp.controller;

import com.BLOG.bloggingApp.dto.CommentDto;
import com.BLOG.bloggingApp.entity.Comment;
import com.BLOG.bloggingApp.exception.ResourceNotFoundException;
import com.BLOG.bloggingApp.service.implementationService.CommentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/addComment/postedBy/{userId}/blog/{blogId}/hasParent/{parentId}/commentedBy/{commentedBy}")
    public String addComment(@PathVariable("blogId") Long blogId,@PathVariable("userId")Long userId, @PathVariable("parentId")Long parentId, @RequestBody Comment comment,@PathVariable Long commentedBy) throws ResourceNotFoundException {
        return commentService.addComment(blogId,userId,parentId,comment,commentedBy);
    }
}
