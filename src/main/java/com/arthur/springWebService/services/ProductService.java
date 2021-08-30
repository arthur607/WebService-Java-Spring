package com.arthur.springWebService.services;

import com.arthur.springWebService.entities.Category;
import com.arthur.springWebService.entities.Product;
import com.arthur.springWebService.repositories.CategoryRepository;
import com.arthur.springWebService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }

}
