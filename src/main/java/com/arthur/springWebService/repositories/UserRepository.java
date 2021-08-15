package com.arthur.springWebService.repositories;

import com.arthur.springWebService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
