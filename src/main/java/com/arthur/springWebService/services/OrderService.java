package com.arthur.springWebService.services;

import com.arthur.springWebService.entities.Order;
import com.arthur.springWebService.entities.User;
import com.arthur.springWebService.repositories.OrderRepository;
import com.arthur.springWebService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
   // public User findById1(Long id){
    //    Optional<User> obj = userRepository.findById(id);
     //   Function<Optional<User>, User> buscarUser = idUsuario -> new User();
     //   return buscarUser.apply(obj);
   // }


}
