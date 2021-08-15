package com.arthur.springWebService.repositories;

import com.arthur.springWebService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long> {


}
