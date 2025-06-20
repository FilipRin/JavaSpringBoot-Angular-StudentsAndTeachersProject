package com.example.demo.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "korisnici")
public class User {


    @Id
    @Column(name = "korisnicko_ime")
    private String korisnickoIme;

    private String lozinka;
    private String ime;
    private String prezime;
    private String tip;
}
