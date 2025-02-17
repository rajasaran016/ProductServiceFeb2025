package com.firstapp.productservicefeb2025.service;

import com.firstapp.productservicefeb2025.DTO.FakeStoreResponseDTO;
import com.firstapp.productservicefeb2025.Model.Product;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface ProductService {

    Product getProductById(Integer id);
    List<Product> getAllProducts();
    Product createProduct(String title, String description, String image, String catTitle);

}
