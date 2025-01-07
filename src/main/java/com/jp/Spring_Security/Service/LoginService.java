package com.jp.Spring_Security.Service;

import com.jp.Spring_Security.Model.DTO.Credentials;
import com.jp.Spring_Security.Model.DTO.LoginResponse;
import com.jp.Spring_Security.Model.Entity.User;
import com.jp.Spring_Security.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class LoginService {

UserRepository userRepository;
PasswordEncoder passwordEncoder;
JWTService jwtService;

    public LoginResponse login(Credentials credentials){
       User user = userRepository.findByName(credentials.getUsername()).orElseThrow(() -> new NoSuchElementException("Usuário com este nome não existe."));
       if(passwordEncoder.matches(credentials.getPassword(), user.getPassword())){
         String token = jwtService.generateToken(user);
         user.setToken(token);

       } else {
           throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "senha inválida.");
       }
    }
}
