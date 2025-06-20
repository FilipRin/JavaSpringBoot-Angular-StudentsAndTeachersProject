package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Activity;
import com.example.demo.model.Prijava;
import com.example.demo.model.PrijavaId;
import com.example.demo.model.Sala;
import com.example.demo.model.User;

import java.util.List;


public interface PrijavaRepository extends JpaRepository<Prijava, PrijavaId>{

    List<Prijava> findByStudent(User student);

    List<Prijava> findByAktivnost(Activity aktivnost);

    List<Prijava> findBySala(Sala sala);

}
