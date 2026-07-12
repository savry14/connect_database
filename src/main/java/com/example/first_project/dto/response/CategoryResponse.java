package com.example.first_project.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CategoryResponse {
    private Long cateId;
    private String cateName;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;
}
