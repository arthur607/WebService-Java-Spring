package com.arthur.springWebService.config;

import com.arthur.springWebService.entities.*;
import com.arthur.springWebService.entities.enums.OrderStatus;
import com.arthur.springWebService.repositories.*;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Category> listCategory = new ArrayList<>();
        listCategory.add(new Category(null,"Marjory"));
        listCategory.add(new Category(null,"Alice"));

        List<User> list = new ArrayList<>();
        list.add(new User(null,"Arthur","arthur@garcia.com","12345"));
        list.add(new User(null,"Pedro","pedro@luiz.com","54321"));

        List<Order> listOrder = new ArrayList<>();
        listOrder.add(new Order(null, Instant.now(),list.get(1), OrderStatus.PAID));

        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product(null,"Saia Gaya","Linda Saia cor preta",100.0,"teste.img"));

//        listProduct.get(0).getCategories().add(listCategory.get(1));    infinity loop in join table
        listProduct.get(0).getCategories().add(listCategory.get(0));

        OrderItem orderOne = new OrderItem(listOrder.get(0),listProduct.get(0),2,listProduct.get(0).getPrice());

        Payment pay1 = new Payment(null, Instant.now(),listOrder.get(0));
        listOrder.get(0).setPayment(pay1);

        userRepository.saveAll(Arrays.asList(list.get(0),list.get(1)));
        orderRepository.saveAll(listOrder);
        categoryRepository.saveAll(listCategory);
        productRepository.saveAll(listProduct);
        orderItemRepository.saveAll(Arrays.asList(orderOne));

    }
}
