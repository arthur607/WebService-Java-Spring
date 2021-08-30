package com.arthur.springWebService.repositories;

import com.arthur.springWebService.entities.Product;
import com.arthur.springWebService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
