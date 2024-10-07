package com.example.Picpaybackend.services;

import com.example.Picpaybackend.domain.user.User;
import com.example.Picpaybackend.domain.user.Usertype;
import com.example.Picpaybackend.dtos.UserDTO;
import com.example.Picpaybackend.repositories.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUsertype() == Usertype.MERCHANT) {
            throw  new Exception("Usuario do tipo lojista não poderá realizar transação");
        }

        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public  User FindUserById(Long id) throws Exception{
      return this.repository.findUserById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }
    public void saveUser(User user){
        this.repository.save(user);
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }
}
