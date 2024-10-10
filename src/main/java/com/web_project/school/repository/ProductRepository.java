package com.web_project.school.repository;

import com.web_project.school.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}