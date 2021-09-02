package com.arthur.springWebService.entities;

import com.arthur.springWebService.entities.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private Instant instant;
     @ManyToOne
     @JoinColumn(name = "client_id")
     private User client;

     @OneToMany(mappedBy = "id.order")
     private Set<OrderItem> items = new HashSet<>();
     private OrderStatus orderStatus;

     public  Order(){

     }

     public Order(Long id, Instant instant, User client, OrderStatus orderStatus) {
          this.id = id;
          this.instant = instant;
          this.client = client;
          this.orderStatus = orderStatus;
     }

     public Set<OrderItem> getItems(){
          return items;
     }
}
