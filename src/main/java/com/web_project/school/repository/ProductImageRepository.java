package com.web_project.school.repository;

import com.web_project.school.model.ProductImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductImageRepository extends JpaRepository<ProductImageModel, UUID> {
}