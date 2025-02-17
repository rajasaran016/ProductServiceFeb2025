package com.firstapp.productservicefeb2025.service;

import com.firstapp.productservicefeb2025.DTO.FakeStoreResponseDTO;
import com.firstapp.productservicefeb2025.Model.Category;
import com.firstapp.productservicefeb2025.Model.Product;
import com.firstapp.productservicefeb2025.Repository.CategoryRepo;
import com.firstapp.productservicefeb2025.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Integer id) {
        Product response = productRepo.findById(id).get();
        System.out.println("Fetched product" + response);
        return response;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, String description, String image, String catTitle) {

        validateInputRequest(title, description, image, catTitle);

        Product product = new Product();
        Category category = new Category();

        product.setTitle(title);
        product.setDescription(description);
        product.setImage(image);
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());

        Category existingCategory = categoryRepo.findByTitle(catTitle).get();

        if (existingCategory == null) {
            category.setTitle(catTitle);
        }

        // Save Category
        product.setCategory(category);

        // Save product
        Product response = productRepo.save(product);

        return response;
    }

    private void validateInputRequest(String title, String description, String image, String catTitle) {

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (image == null || image.isEmpty()) {
            throw new IllegalArgumentException("Image cannot be null or empty");
        }
        if (catTitle == null || catTitle.isEmpty()) {
            throw new IllegalArgumentException("Category title cannot be null or empty");
        }
    }
}
