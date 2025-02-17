package com.firstapp.productservicefeb2025.Repository;

import com.firstapp.productservicefeb2025.Model.Category;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    //JPA Query
    Optional<Category> findByTitle(String title);

    Optional<Category> findById(Integer id);
}
