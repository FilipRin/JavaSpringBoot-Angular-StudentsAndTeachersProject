package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Activity;
import com.example.demo.model.User;

public interface ActivityRepository extends JpaRepository<Activity, Long>{
   
    Optional<Activity> findById(Long id);

    List<Activity> findByStatus(int status);

    List<Activity> findByNastavnik(User nastavnik);



}
