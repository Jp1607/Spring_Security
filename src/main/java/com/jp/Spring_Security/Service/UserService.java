package com.jp.Spring_Security.Service;

import com.jp.Spring_Security.Model.Entity.User;
import com.jp.Spring_Security.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User FindById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não existe"));
    }
}
