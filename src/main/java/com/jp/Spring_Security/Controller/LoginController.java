package com.jp.Spring_Security.Controller;

import com.jp.Spring_Security.Model.DTO.Credentials;
import com.jp.Spring_Security.Model.DTO.Registration;
import com.jp.Spring_Security.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;
    HttpStatus httpStatus = HttpStatus.OK;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/")
    public ResponseEntity<String> login(@RequestBody Credentials credentials) {

        try {
            return ResponseEntity.status(httpStatus).body(loginService.login(credentials));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Registration registration) {

        try {
            return ResponseEntity.status(httpStatus).body(loginService.register(registration));
        } catch (Exception e) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity.status(httpStatus).body(e.getMessage());
        }
    }
}
