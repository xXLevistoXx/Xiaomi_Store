package com.web_project.school.service;

import com.web_project.school.model.ProductImageModel;

import java.util.List;
import java.util.UUID;

public interface ProductImageService {
    public List<ProductImageModel> findAllProductImages();

    public ProductImageModel findProductImageById(UUID id);

    public ProductImageModel addProductImage(ProductImageModel productImage);

    public ProductImageModel updateProductImage(ProductImageModel productImage);

    public void deleteProductImage(UUID id);
}