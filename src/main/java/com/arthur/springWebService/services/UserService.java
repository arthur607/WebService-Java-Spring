package com.arthur.springWebService.services;

import com.arthur.springWebService.entities.User;
import com.arthur.springWebService.exception.ResourceNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }


   // public User findById1(Long id){
    //    Optional<User> obj = userRepository.findById(id);
     //   Function<Optional<User>, User> buscarUser = idUsuario -> new User();
     //   return buscarUser.apply(obj);
   // }

    public User insert(User obj){
       return userRepository.save(obj);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public User update(Long id, User obj){
        User entity = userRepository.getById(id);
        updateData(entity,obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
    }


}
