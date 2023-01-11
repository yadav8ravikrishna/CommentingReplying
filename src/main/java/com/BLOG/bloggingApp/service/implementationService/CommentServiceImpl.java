package com.BLOG.bloggingApp.service.implementationService;

import com.BLOG.bloggingApp.dto.CommentDto;
import com.BLOG.bloggingApp.entity.Blog;
import com.BLOG.bloggingApp.entity.Comment;
import com.BLOG.bloggingApp.entity.User;
import com.BLOG.bloggingApp.exception.ResourceNotFoundException;
import com.BLOG.bloggingApp.mapper.CommentMapper;
import com.BLOG.bloggingApp.repository.BlogRepo;
import com.BLOG.bloggingApp.repository.CommentRepo;
import com.BLOG.bloggingApp.repository.UserRepo;
import com.BLOG.bloggingApp.service.CommentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentServiceImpl implements CommentServiceInterface {

    private final CommentRepo commentRepo;
    private final UserRepo userRepo;
    private final BlogRepo blogRepo;

    public CommentServiceImpl(CommentRepo commentRepo,
                              UserRepo userRepo,
                              BlogRepo blogRepo) {
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
        this.blogRepo = blogRepo;
    }

//    @Override
//    public String addComment(Long blogId,Long userId, Long parentId, Comment comment,Long commentedBy) throws ResourceNotFoundException {
//
//        Optional<User> user = userRepo.findById(userId);
//
//        if(parentId==null) {
//            if (user.isPresent()) {
//                Set<Blog> blogs = user.get().getBlogs();
//                for (Blog blog : blogs) {
//                    if (Objects.equals(blog.getId(), blogId)) {
//                        comment.setUser(userRepo.findById(commentedBy).get());
//                        blog.getComments().add(comment);
//                        blogRepo.save(blog);
//                    } else {
//                        throw new ResourceNotFoundException("blog not found");
//                    }
//                }
//            }else{throw new ResourceNotFoundException("user not found");}
//        }else {
//            if (user.isPresent()) {
//                Set<Blog> blogs = user.get().getBlogs();
//                for (Blog blog : blogs) {
//                    if (Objects.equals(blog.getId(), blogId)) {
//                        Set<Comment> comments=blog.getComments();
//                        for (Comment comment1:comments){
//                            if (Objects.equals(comment1.getId(), parentId)) {
//                                comment.setUser(userRepo.findById(commentedBy).get());
//                                comment1.getReplies().add(comment);
//                                commentRepo.save(comment1);
//                            }else {throw new ResourceNotFoundException("Comment with id: "+parentId+" not found");}
//                        }
//                    } else {
//                        throw new ResourceNotFoundException("blog not found");
//                    }
//                }
//            }else{throw new ResourceNotFoundException("user not found");}
//        }
//
//
//
////        userRepo.findById(userId).get().getBlogs().stream().map(blog -> {
////            if(Objects.equals(blog.getId(), blogId)){
////                blog.getComments().add(comment);
////            }
////           return blogRepo.save(blog);
////        });
////        if (parentId==0){
//////            Comment firstComment = commentRepo.save(comment);
////            blog.setComments(comments);
////        }
//       // Comment comment = CommentMapper.mapCommentDtoToComment(commentDto);
//
//        //r//eturn commentRepo.save(comment);
//        commentRepo.save(comment);
//        return "Comment added";
//    }
  @Override
  public String addComment(Long blogId, Long parentId, Comment comment,Long commentedBy) throws ResourceNotFoundException {
        Optional<User> user = userRepo.findById(commentedBy);
        Optional<Blog> blog = blogRepo.findById(blogId);
        if(user.isPresent()){
            if (blog.isPresent()){
                if(parentId==0){
                    comment.setUser(user.get());
                    blog.get().getComments().add(comment);
                    blogRepo.save(blog.get());
                }else {
                    Optional<Comment> comment1 = commentRepo.findById(parentId);
                    if (comment1.isPresent()){
                        comment.setUser(user.get());
                        comment1.get().getReplies().add(comment);
                        commentRepo.save(comment1.get());
                    }else {throw new ResourceNotFoundException("Comment with id: "+parentId+" not found");}
                }
            }else {throw  new ResourceNotFoundException("blog not found");}
        }else {throw new ResourceNotFoundException("user not found");}

        return "Comment Added";
    }




    @Override
    public Optional<Comment> getAComment(Long id) {
        return commentRepo.findById(id);
    }

    @Override
    public Optional<Comment> editComment(Long id, Comment comment) {
        Optional<Comment> oldComment = commentRepo.findById(id);
        oldComment.get().setCommentContent(comment.getCommentContent());
        return oldComment;
    }

    @Override
    public String deleteComment(Long id) {
        commentRepo.deleteById(id);
        return "deleted";
    }
//    @Override
//    public Comment commentInsideComment(Long parentId, boolean root) throws ResourceNotFoundException {
//        Comment comment = new Comment();
//        if (!root) {
//            comment = commentRepo.findById(parentId)
//                    .orElseThrow(() -> new ResourceNotFoundException("id does Not Exist"));
//
//        }
//
//        List<CommentDto> comments = commentRepo.findByParent(parentId);
//        if (!comments.isEmpty()) {
//            for (CommentDto commentDto : comments) {
//                commentInsideComment(commentDto.getId(), false);
//            }
//        }
//        return comment;
//    }
}
