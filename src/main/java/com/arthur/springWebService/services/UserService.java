package com.arthur.springWebService.services;

import com.arthur.springWebService.entities.User;
import com.arthur.springWebService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }


   // public User findById1(Long id){
    //    Optional<User> obj = userRepository.findById(id);
     //   Function<Optional<User>, User> buscarUser = idUsuario -> new User();
     //   return buscarUser.apply(obj);
   // }

    public User insert(User obj){
       return userRepository.save(obj);
    }


}
