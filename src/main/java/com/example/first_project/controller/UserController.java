package com.example.first_project.controller;
import com.example.first_project.entity.UserEntity;
import com.example.first_project.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public List<UserEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public UserEntity create(@RequestBody UserEntity user) {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public UserEntity update(@PathVariable Long id,
                             @RequestBody UserEntity user) {
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}
