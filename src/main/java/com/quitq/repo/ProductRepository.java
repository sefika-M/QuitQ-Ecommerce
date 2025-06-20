package com.quitq.repo;

import com.quitq.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductNameContainingIgnoreCase(String productName);
    @Query("SELECT p FROM Product p WHERE LOWER(p.category.catName) LIKE LOWER(CONCAT('%', :catName, '%'))")
    List<Product> searchByCategoryName(@Param("catName") String catName);
}
