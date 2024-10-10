package com.web_project.school.repository;

import com.web_project.school.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {
}