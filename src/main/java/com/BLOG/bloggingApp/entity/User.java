package com.BLOG.bloggingApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    //private String address;
    @OneToMany(targetEntity = Blog.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usersBlog_fk",referencedColumnName = "id")
    Set<Blog> blogs;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Set<Comment> comments;
    

}
