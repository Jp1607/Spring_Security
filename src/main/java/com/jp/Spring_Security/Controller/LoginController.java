package com.jp.Spring_Security.Controller;

import com.jp.Spring_Security.Model.DTO.Credentials;
import com.jp.Spring_Security.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

 @PostMapping("/")
    public ResponseEntity<String> auth(HttpServletRequest httpServletRequest, @RequestBody Credentials credentials){


 }
}
