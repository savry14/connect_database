package com.example.first_project.service.impl;

import com.example.first_project.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAll();

    UserEntity getById(Long id);

    UserEntity save(UserEntity user);

    UserEntity update(Long id, UserEntity user);

    void delete(Long id);
}
