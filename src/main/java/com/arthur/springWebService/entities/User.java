package com.arthur.springWebService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import sun.security.util.Password;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@AllArgsConstructor
@ToString
@Table(name = "tb_user")
@Entity                                                     //mapping entity in repository
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //id auto increment
    private Long id;
    private String nome;
    private String email;
    private String password;

    @OneToMany(mappedBy = "client")
    @Setter(value =AccessLevel.NONE)
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    public User(Long id, String nome, String email, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
