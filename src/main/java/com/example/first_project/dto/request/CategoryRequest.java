package com.example.first_project.dto.request;

import lombok.Data;

@Data
public class CategoryRequest {
    private String cateName;
    private String image;
    private Long userId;
}
