package com.example.first_project.service.impl;

import com.example.first_project.dto.request.CategoryRequest;
import com.example.first_project.dto.response.CategoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface CategoryService {
    CategoryResponse create(CategoryRequest categoryRequest, MultipartFile file) throws IOException;
    List<CategoryResponse> getCategory();
    public void deleteCategory(Long cateId);
    CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest, MultipartFile file)throws IOException;

}
