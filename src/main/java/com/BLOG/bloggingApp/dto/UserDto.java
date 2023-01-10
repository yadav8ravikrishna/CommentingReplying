package com.BLOG.bloggingApp.dto;

import com.BLOG.bloggingApp.entity.Blog;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private Long id;
    private String userName;
    //private String address;
    Set<BlogDto> blogs;

}
