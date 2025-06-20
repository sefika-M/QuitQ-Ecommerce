package com.quitq.serviceImpl;

import com.quitq.exception.ResourceNotFoundException;
import com.quitq.model.Product;
import com.quitq.repo.ProductRepository;
import com.quitq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchByCategoryName(String category) {
        return productRepository.searchByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return productRepository.findByProductNameContainingIgnoreCase(productName);
        
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + productId + " not found"));
    }

    @Override
    public String deleteProduct(int productId) {
        Product product = getProductById(productId); // throws exception if not found
        productRepository.delete(product);
        return "Product with ID " + productId + " deleted successfully";
    }
}
