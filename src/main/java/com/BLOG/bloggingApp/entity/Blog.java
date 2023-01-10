package com.BLOG.bloggingApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private byte[] image;
    private String description;
    //private LocalDate postDate;
    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "blogComment_fk",referencedColumnName = "id")
    Set<Comment> comments;
    //@ManyToOne
//    private User user;
}
