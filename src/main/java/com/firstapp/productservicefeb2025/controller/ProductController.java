package com.firstapp.productservicefeb2025.controller;

import com.firstapp.productservicefeb2025.DTO.CreateProductRequestDTO;
import com.firstapp.productservicefeb2025.Model.Product;
import com.firstapp.productservicefeb2025.service.FakeStoreProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//RestController class for product
@RestController
public class ProductController {

    private final FakeStoreProductService service;

    public ProductController(FakeStoreProductService inputService) {
        this.service = inputService;
    }

    //get product details by product Id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) { //path variables to get params

        // setting the Validations
        if(id == 100) {
            throw new IllegalArgumentException("id cannot be null");
        }
        // return the product response from FakeStoreProductService api
        return service.getProductById(id);
    }

    //create the product and post in to the application
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO request) {

        //setting the validations
        if(request.getTitle() == null) {
            throw new IllegalArgumentException("title cannot be null");
        }
        if(request.getDescription() == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
        if(request.getCategory().getTitle() == null) {
            throw new IllegalArgumentException("category title cannot be null");
        }

        // return the created product response from FakeStoreProductService api
        return service.createProduct(request.getTitle(), request.getDescription(), request.getImage(),
                request.getCategory().getTitle());
    }

    //get all products on the application
    @GetMapping("/products")
    public List<Product> getAllProducts(){

        // return list of all product detail from FakeStoreProductService api
        return service.getAllProducts();
    }

    //update the product in the application by product Id
    @PutMapping("/product/{id}")
    public void updateProductById(@PathVariable("id") Integer id){

    }

    //delete product from the database by Id
    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Integer id){

    }
}
