package com.BLOG.bloggingApp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentContent;
    //private LocalDate commentedDate;
    //private Long parentId;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<Comment> replies;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usersComment_fk",referencedColumnName = "id")
    private User user;
}
