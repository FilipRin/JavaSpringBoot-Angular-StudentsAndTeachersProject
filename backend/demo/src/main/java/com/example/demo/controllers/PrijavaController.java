package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Activity;
import com.example.demo.model.Prijava;
import com.example.demo.model.Sala;
import com.example.demo.model.User;
import com.example.demo.service.PrijavaService;

@RestController
@RequestMapping("/api/prijave")
@CrossOrigin("*")
public class PrijavaController {

    @Autowired
    private PrijavaService prijavaService;
    

    @GetMapping("/student/{studentId}")
    public List<Prijava> getPrijaveByStudent(@PathVariable String studentId) {
        User student = new User();
        student.setKorisnickoIme(studentId);
        return prijavaService.getPrijaveByStudent(student);
    }

    @GetMapping("/aktivnost/{aktivnostId}")
    public List<Prijava> getPrijaveByAktivnost(@PathVariable Long aktivnostId) {
        Activity aktivnost = new Activity();
        aktivnost.setId(aktivnostId);
        return prijavaService.getPrijaveByAktivnost(aktivnost);
    }

    @GetMapping("/sala/{salaNaziv}")
    public List<Prijava> getPrijaveBySala(@PathVariable String salaNaziv) {
        Sala sala = new Sala();
        sala.setNaziv(salaNaziv);
        return prijavaService.getPrijaveBySala(sala);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Prijava createPrijava(@RequestBody Prijava prijava){
        return prijavaService.savePrijava(prijava);
    }




}
