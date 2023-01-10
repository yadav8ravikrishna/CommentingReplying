package com.BLOG.bloggingApp.dto;

import lombok.*;
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public class UserDtoForComment {
        private Long id;
        private String userName;
    }
