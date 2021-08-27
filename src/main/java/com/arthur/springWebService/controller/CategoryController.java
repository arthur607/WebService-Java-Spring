package com.arthur.springWebService.controller;

import com.arthur.springWebService.entities.Category;
import com.arthur.springWebService.entities.Order;
import com.arthur.springWebService.services.CategoryService;
import com.arthur.springWebService.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category>findById(@PathVariable Long id ){
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
