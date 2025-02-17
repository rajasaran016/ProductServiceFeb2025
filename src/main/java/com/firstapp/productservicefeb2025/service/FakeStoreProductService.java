package com.firstapp.productservicefeb2025.service;

import com.firstapp.productservicefeb2025.DTO.FakeStoreResponseDTO;
import com.firstapp.productservicefeb2025.Model.Category;
import com.firstapp.productservicefeb2025.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductService {

    private final RestTemplate restTemplate; //creating object for rest API Which help us to make http call

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreResponseToProduct(FakeStoreResponseDTO response) {

        // Creating objects for the product and category class
        Product product = new Product();
        Category category = new Category();

        // mapping all the details
        category.setTitle(response.getCategory());
        //product.setId(response.getId());
        product.setCategory(category);
        product.setDescription(response.getDescription());
        product.setImage(response.getImageUrl());
        product.setTitle(response.getTitle());

        return product;
    }

    public Product getProductById(Integer id) {

        Product product = new Product();

        //call FakeStore API of single product by product id
        ResponseEntity<FakeStoreResponseDTO> fakeStoreResponse =
                restTemplate.getForEntity("https://fakestoreapi.com/products/"+ id, FakeStoreResponseDTO.class);

        // Get Response of single product by product id
        FakeStoreResponseDTO response = fakeStoreResponse.getBody();

        // Covert the response to product model
        if(response == null) {
            throw new IllegalArgumentException("FakeStoreResponse is not found!!");
        }
        product = convertFakeStoreResponseToProduct(response);

        // return
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> response = new ArrayList<>();

        //call FakeStore API of all product details
        ResponseEntity<FakeStoreResponseDTO[]> fakeStoreAllProducts =
                restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreResponseDTO[].class);

        // Null pointer validation for the fakeStoreAllProducts response
        assert fakeStoreAllProducts.getBody() != null;

        //iterate over each product details of the list of product and covert response with respect to product model
        for(FakeStoreResponseDTO fakeStoreResponse : fakeStoreAllProducts.getBody()) {
            response.add(convertFakeStoreResponseToProduct(fakeStoreResponse));
        }

        return response;
    }

    public Product createProduct(String title, String description, String image, String catTitle) {

        Product response = new Product();

        FakeStoreResponseDTO requestBody = new FakeStoreResponseDTO();
        requestBody.setTitle(title);
        requestBody.setDescription(description);
        requestBody.setImageUrl(image);
        requestBody.setCategory(catTitle);

        ResponseEntity<FakeStoreResponseDTO> fakeStoreResponse =
         restTemplate.postForEntity("https://fakestoreapi.com/products", requestBody, FakeStoreResponseDTO.class);

        response = convertFakeStoreResponseToProduct(Objects.requireNonNull(fakeStoreResponse.getBody()));

        return response;
    }
}
