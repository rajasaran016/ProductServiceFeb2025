package com.firstapp.productservicefeb2025.controller;

import org.springframework.web.bind.annotation.*;

//RestController class for product
@RestController
public class ProductController {

    //get product details by product Id
    @GetMapping("/product/{id}")
    public void getProductById(@PathVariable("id") Integer id) { //path variables to get params

    }

    //create the product and post in to the application
    @PostMapping("/products")
    public void createProduct(){

    }
    //get all products on the application
    @GetMapping("/products")
    public void getAllProducts(){

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
