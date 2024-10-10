package com.web_project.school.service;

import com.web_project.school.model.ProductImageModel;
import com.web_project.school.repository.ProductImageRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository productImageRepository;

    public InMemoryProductImageServiceImpl(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    @Override
    public List<ProductImageModel> findAllProductImages() {
        return productImageRepository.findAll(Sort.by("id"));
    }

    @Override
    public ProductImageModel findProductImageById(UUID id) {
        return productImageRepository.findById(id).orElse(null);
    }

    @Override
    public ProductImageModel addProductImage(ProductImageModel productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public ProductImageModel updateProductImage(ProductImageModel productImage) {
        if (productImageRepository.existsById(productImage.getId())) {
            return productImageRepository.save(productImage);
        }
        return null;
    }

    @Override
    public void deleteProductImage(UUID id) {
        if (productImageRepository.existsById(id)) {
            productImageRepository.deleteById(id);
        }
    }
}