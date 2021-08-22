package com.arthur.springWebService.controller;

import com.arthur.springWebService.entities.User;
import com.arthur.springWebService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

       @Autowired
       private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>>findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User>findById1(@PathVariable Long id ){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}