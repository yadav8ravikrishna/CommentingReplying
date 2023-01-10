package com.BLOG.bloggingApp.dto;

import com.BLOG.bloggingApp.entity.Comment;
import com.BLOG.bloggingApp.entity.User;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BlogDto {
    private Long id;
    private String description;
    Set<CommentDto> comments;
}
