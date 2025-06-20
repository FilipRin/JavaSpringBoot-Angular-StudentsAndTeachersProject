package com.example.demo.dto;
import lombok.Data;

@Data
public class LoginRequest {

    private String korisnickoIme;
    private String lozinka;
    private String tip;

}
