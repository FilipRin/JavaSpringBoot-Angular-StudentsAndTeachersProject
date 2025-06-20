package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Activity;
import com.example.demo.model.Prijava;
import com.example.demo.model.Sala;
import com.example.demo.model.User;
import com.example.demo.repository.PrijavaRepository;

import jakarta.transaction.Transactional;

@Service
public class PrijavaService {

    @Autowired
    private PrijavaRepository prijavaRepository;

    @Autowired
    private ActivityService activityService;


    public List<Prijava> getPrijaveByStudent(User student) {
        return prijavaRepository.findByStudent(student);
    }

    public List<Prijava> getPrijaveByAktivnost(Activity aktivnost) {
        return prijavaRepository.findByAktivnost(aktivnost);
    }

    public List<Prijava> getPrijaveBySala(Sala sala) {
        return prijavaRepository.findBySala(sala);
    }

    @Transactional
    public Prijava savePrijava(Prijava prijava) {
        activityService.decreaseCapacity(prijava.getAktivnost().getId(), prijava.getSala().getNaziv());
        return prijavaRepository.save(prijava);
    }


}
