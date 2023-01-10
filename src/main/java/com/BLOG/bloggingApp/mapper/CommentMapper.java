package com.BLOG.bloggingApp.mapper;

import com.BLOG.bloggingApp.dto.CommentDto;
import com.BLOG.bloggingApp.entity.Comment;
import com.BLOG.bloggingApp.entity.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

public class CommentMapper {

    /**
     * maps comment to commentDto
     **/
    public static CommentDto mapCommentToCommentDto(Comment comment) {
        CommentDto commentDto = CommentDto.builder()
                .id(comment.getId())
                .commentContent(comment.getCommentContent())
                //.commentedDate(comment.getCommentedDate())
                .build();

        User user = comment.getUser();
        commentDto.setUser(UserForCommentMapper.mapUserToUserDto(user));

        if (comment.getReplies() != null) {
            Set<CommentDto> commentReplyDTOS = new HashSet<>();
            for (Comment commentReply : comment.getReplies()) {
                commentReplyDTOS.add(mapCommentToCommentDto(commentReply));
            }
            commentDto.setReplies(commentReplyDTOS);

        }
        return commentDto;
    }

    /**
     * maps commentDto to comment
     **/
    public static Comment mapCommentDtoToComment(CommentDto commentDto){
        return Comment.builder()
                .id(commentDto.getId())
                .commentContent(commentDto.getCommentContent())
                //.commentedDate(commentDto.getCommentedDate())
                .build();

    }
}
