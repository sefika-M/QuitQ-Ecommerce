package com.quitq.service;

import com.quitq.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    List<Product> searchByCategoryName(String categoryName);
    List<Product> getProductsByName(String productName);
    Product getProductById(int productId);
    String deleteProduct(int productId);
}
