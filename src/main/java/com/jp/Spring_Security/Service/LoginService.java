package com.jp.Spring_Security.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.Spring_Security.Model.DTO.Credentials;
import com.jp.Spring_Security.Model.DTO.Registration;
import com.jp.Spring_Security.Model.Entity.User;
import com.jp.Spring_Security.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Service
public class LoginService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JWTService jwtService;
    ObjectMapper objectMapper;

    @Autowired
    public LoginService(UserRepository userRepository, JWTService jwtService, ObjectMapper objectMapper){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.objectMapper = objectMapper;
    }

    public String login(Credentials credentials) throws ResponseStatusException{
        User user = userRepository.findByUsername(credentials.getUsername()).orElseThrow(() -> new NoSuchElementException("Usuário com este nome não existe."));
        if (passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
            return jwtService.generateToken(user);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "senha inválida.");
        }
    }

    public String register(Registration registration) {
        registration.setPassword(passwordEncoder.encode(registration.getPassword()));
        User user = new User(registration);
        Credentials credentials = new Credentials(registration);
        userRepository.save(user);
        return login(credentials);
    }
}
