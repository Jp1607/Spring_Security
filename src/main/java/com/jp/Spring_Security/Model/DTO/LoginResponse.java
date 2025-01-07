package com.jp.Spring_Security.Model.DTO;

import com.fasterxml.jackson.annotation.JsonView;

public class LoginResponse {

    @JsonView
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
