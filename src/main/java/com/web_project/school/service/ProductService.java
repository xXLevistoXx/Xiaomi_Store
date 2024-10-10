package com.web_project.school.service;

import com.web_project.school.model.ProductModel;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<ProductModel> findAllProducts();

    public ProductModel findProductById(UUID id);

    public ProductModel addProduct(ProductModel product);

    public ProductModel updateProduct(ProductModel product);

    public void deleteProduct(UUID id);
}