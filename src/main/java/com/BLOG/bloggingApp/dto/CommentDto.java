package com.BLOG.bloggingApp.dto;

import com.BLOG.bloggingApp.entity.Comment;
import com.BLOG.bloggingApp.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentDto {
    private Long id;
    private String commentContent;
    //private LocalDate commentedDate;
    private UserDto user;
    Set<CommentDto> replies;
}
