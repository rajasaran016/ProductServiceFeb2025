package com.firstapp.productservicefeb2025.Repository;

import com.firstapp.productservicefeb2025.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
