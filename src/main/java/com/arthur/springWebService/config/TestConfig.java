package com.arthur.springWebService.config;

import com.arthur.springWebService.entities.Order;
import com.arthur.springWebService.entities.User;
import com.arthur.springWebService.repositories.OrderRepository;
import com.arthur.springWebService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")          //properties 'test'
public class TestConfig implements CommandLineRunner {

    @Autowired                                      //dependency of server, weak dependency
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> list = new ArrayList<>();
        list.add(new User(null,"Arthur","arthur@garcia.com","12345"));
        list.add(new User(null,"Pedro","pedro@luiz.com","54321"));

        List<Order> listOrder = new ArrayList<>();
        listOrder.add(new Order(null, Instant.now(),list.get(1)));

        userRepository.saveAll(Arrays.asList(list.get(0),list.get(1)));
        orderRepository.saveAll(listOrder);

    }
}
