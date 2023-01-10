package com.BLOG.bloggingApp.mapper;

import com.BLOG.bloggingApp.dto.BlogDto;
import com.BLOG.bloggingApp.dto.CommentDto;
import com.BLOG.bloggingApp.entity.Blog;
import com.BLOG.bloggingApp.entity.Comment;

import java.util.HashSet;
import java.util.Set;

public class BlogMapper {
    /**
     * BlogDto comment to Blog
     **/
    public static Blog mapBlogDtoToBlog(BlogDto blogDto){
        return Blog.builder()
                .id(blogDto.getId())
                .description(blogDto.getDescription())
                .build();


    }
    /**
     * Blog comment to BlogDto
     **/
    public static BlogDto mapBlogToBlogDto(Blog blog){
        BlogDto blogDto= BlogDto.builder()
                .id(blog.getId())
                .description(blog.getDescription())
                .build();

        Set<Comment> comments = blog.getComments();
        Set<CommentDto> commentDtoSet = new HashSet<>();
        for (Comment comment : comments){
            CommentDto commentDto = CommentMapper.mapCommentToCommentDto(comment);
            commentDtoSet.add(commentDto);
        }

        blogDto.setComments(commentDtoSet);
        return blogDto;
    }
}
