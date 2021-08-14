package com.arthur.springWebService.controller;

import com.arthur.springWebService.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User>findAll(){
        User arthur = new User(1L,"arthur","arthur@garcia","12345");
        return ResponseEntity.ok().body(arthur);
    }
}
