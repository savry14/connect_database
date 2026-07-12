package com.example.first_project.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class UserResponse {
    private Long id;
    private String userName;
    private String gender;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
