package com.web_project.school.service;

import com.web_project.school.model.CategoryModel;
import com.web_project.school.repository.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryCategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public InMemoryCategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> findAllCategories() {
        return categoryRepository.findAll(Sort.by("id"));
    }

    @Override
    public CategoryModel findCategoryById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryModel addCategory(CategoryModel category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryModel updateCategory(CategoryModel category) {
        if (categoryRepository.existsById(category.getId())) {
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(UUID id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
    }
}