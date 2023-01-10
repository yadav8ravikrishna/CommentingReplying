package com.BLOG.bloggingApp.repository;

import com.BLOG.bloggingApp.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog,Long> {
}
