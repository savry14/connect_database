package com.example.first_project.controller;

import com.example.first_project.dto.request.CategoryRequest;
import com.example.first_project.dto.response.CategoryResponse;
import com.example.first_project.service.impl.CategoryService;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
@Table(name = "db_mini_crudapi")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponse create(@ModelAttribute CategoryRequest categoryRequest, @RequestParam("file")MultipartFile file)throws IOException{
        return categoryService.create(categoryRequest, file);
    }

    @GetMapping
    public List<CategoryResponse> getCategory(){
        return categoryService.getCategory();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCategory(@PathVariable Long id, @ModelAttribute CategoryRequest categoryRequest, @RequestParam("file") MultipartFile file)throws IOException{
        return categoryService.updateCategory(id, categoryRequest, file);
    }
}
