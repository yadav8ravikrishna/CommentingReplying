package com.BLOG.bloggingApp.service;

import com.BLOG.bloggingApp.dto.CommentDto;
import com.BLOG.bloggingApp.entity.Comment;
import com.BLOG.bloggingApp.entity.User;
import com.BLOG.bloggingApp.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface CommentServiceInterface {
    String addComment(Long blogId, Long parentId, Comment comment,Long commentedBy)throws ResourceNotFoundException ;
    Optional<Comment> getAComment(Long id);
    Optional<Comment> editComment(Long id, Comment comment);
    String deleteComment(Long id);
    //Comment commentInsideComment(Long parentId, boolean root) throws ResourceNotFoundException;

}
