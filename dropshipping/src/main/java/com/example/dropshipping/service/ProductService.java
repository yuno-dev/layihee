package com.example.dropshipping.service;

import com.example.dropshipping.model.Product;
import com.example.dropshipping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Tüm ürünleri getir
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ID'ye göre ürün getir
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    // Yeni ürün oluştur
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Ürünü güncelle
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Ürünü sil
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
