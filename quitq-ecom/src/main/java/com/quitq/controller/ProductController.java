package com.quitq.controller;

import com.quitq.model.Product;
import com.quitq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    
    @GetMapping("/products/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/searchByCategoryName/{category}")
    public List<Product> searchByCategoryName(@PathVariable String category) {
        return productService.searchByCategoryName(category);
    }

    @GetMapping("/getProductsByName/{productName}")
    public List<Product> getProductsByName(@PathVariable String productName) {
        return productService.getProductsByName(productName);
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
