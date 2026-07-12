package com.example.first_project.service.impl;

import com.example.first_project.dto.request.CategoryRequest;
import com.example.first_project.dto.response.CategoryResponse;
import com.example.first_project.entity.CategoryEntity;
import com.example.first_project.exception.FileNotFound;
import com.example.first_project.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest, MultipartFile file) throws IOException{
        String fileName = file.getOriginalFilename();
        String fileUrl = UUID.randomUUID().toString()+"_"+fileName;
        Path path = Paths.get("uploads");
        String imageUrl = "http://localhost:8080/uploads/"+fileUrl;

        if (!Files.exists(path)){
            Files.createDirectories(path);
        }

        Files.copy(file.getInputStream(), path.resolve(fileUrl), StandardCopyOption.REPLACE_EXISTING);
        CategoryEntity category = new CategoryEntity();
        category.setImage(imageUrl);
        category.setCateName(categoryRequest.getCateName());
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        category = categoryRepository.save(category);

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCateId(category.getCateId());
        categoryResponse.setCateName(category.getCateName());
        categoryResponse.setImage(category.getImage());
        categoryResponse.setCreatedAt(category.getCreatedAt());
        categoryResponse.setUpdatedAt(category.getUpdatedAt());
        return categoryResponse;
    }
    @Override
    public List<CategoryResponse> getCategory(){
        List<CategoryEntity> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (CategoryEntity category :  categories){
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setCateId(category.getCateId());
            categoryResponse.setCateName(category.getCateName());
            categoryResponse.setImage(category.getImage());
            categoryResponse.setCreatedAt(category.getCreatedAt());
            categoryResponse.setUpdatedAt(category.getUpdatedAt());
            categoryResponses.add(categoryResponse);
        }
        return categoryResponses;
    }

    @Override
    public void deleteCategory(Long id){
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(()-> new FileNotFound("Category not found!"));
        categoryRepository.delete(category);
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest, MultipartFile file) throws IOException {
        CategoryEntity updatedCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new FileNotFound("Category not found"));

        String fileName = file.getOriginalFilename();
        String fileUrl = UUID.randomUUID() + "_" + fileName;
        Path path = Paths.get("uploads");
        String imageUrl = "http://localhost:8080/uploads/" + fileUrl;

        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        Files.copy(file.getInputStream(),
                path.resolve(fileUrl),
                StandardCopyOption.REPLACE_EXISTING);
        updatedCategory.setCateName(categoryRequest.getCateName());
        updatedCategory.setImage(imageUrl);
        updatedCategory.setUpdatedAt(LocalDateTime.now());
        updatedCategory = categoryRepository.save(updatedCategory);

        CategoryResponse response = new CategoryResponse();
        response.setCateId(updatedCategory.getCateId());
        response.setCateName(updatedCategory.getCateName());
        response.setImage(updatedCategory.getImage());
        response.setCreatedAt(updatedCategory.getCreatedAt());
        response.setUpdatedAt(updatedCategory.getUpdatedAt());

        return response;
    }
}
