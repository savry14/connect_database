package com.example.first_project.service.impl;
import com.example.first_project.entity.UserEntity;
import com.example.first_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public UserEntity getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

    @Override
    public UserEntity update(Long id, UserEntity user) {
        UserEntity old = repository.findById(id).orElseThrow();

        old.setUserName(user.getUserName());
        old.setGender(user.getGender());
        old.setEmail(user.getEmail());

        return repository.save(old);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
