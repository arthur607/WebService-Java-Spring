package com.arthur.springWebService.repositories;

import com.arthur.springWebService.entities.Category;
import com.arthur.springWebService.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
