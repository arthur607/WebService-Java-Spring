package com.arthur.springWebService.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
@Data
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

     public  Order(){

     }
}
