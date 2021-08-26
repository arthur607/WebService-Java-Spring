package com.arthur.springWebService.entities;

import com.arthur.springWebService.entities.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
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

     private OrderStatus orderStatus;



     public  Order(){

     }
}
