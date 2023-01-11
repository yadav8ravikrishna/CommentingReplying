package com.BLOG.bloggingApp.repository;

import com.BLOG.bloggingApp.dto.CommentDto;
import com.BLOG.bloggingApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CommentRepo extends JpaRepository<Comment,Long> {
//    @Query("SELECT NEW  com.BLOG.bloggingApp.dto.CommentDto(c.id, c.commentContent, c.user)" +
//            "FROM Comment as c WHERE parentId = :parentId")
//    public List<CommentDto> findByParent(@Param("parentId") Long parentId);
    }
