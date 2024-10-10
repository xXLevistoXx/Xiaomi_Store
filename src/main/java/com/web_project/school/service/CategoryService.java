package com.web_project.school.service;

import com.web_project.school.model.CategoryModel;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public List<CategoryModel> findAllCategories();

    public CategoryModel findCategoryById(UUID id);

    public CategoryModel addCategory(CategoryModel category);

    public CategoryModel updateCategory(CategoryModel category);

    public void deleteCategory(UUID id);
}