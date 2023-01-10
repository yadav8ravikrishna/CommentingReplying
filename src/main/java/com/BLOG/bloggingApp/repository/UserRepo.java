package com.BLOG.bloggingApp.repository;

import com.BLOG.bloggingApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
