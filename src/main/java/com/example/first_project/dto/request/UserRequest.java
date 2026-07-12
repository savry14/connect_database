package com.example.first_project.dto.request;


import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String gender;
    private String email;
}
