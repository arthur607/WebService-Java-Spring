package com.arthur.springWebService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import sun.security.util.Password;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor

public class User implements Serializable {
    private Long id;
    private String nome;
    private String email;
    private String password;

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
