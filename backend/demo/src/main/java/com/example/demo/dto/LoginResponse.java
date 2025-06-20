package com.example.demo.dto;
import com.example.demo.model.User;

import lombok.Data;

@Data
public class LoginResponse {

    private String message;
    private boolean success;
    private User user;

    public LoginResponse(String message, boolean success, User user){
        this.message = message;
        this.success = success;
        this.user = user;
    }


}
