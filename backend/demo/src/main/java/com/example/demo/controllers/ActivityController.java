package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Activity;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ActivityService;
import com.example.demo.repository.ActivityRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("/active")
    public List<Activity> getActiveActivities() {
        return activityService.getActiveActivities();
    }

    @GetMapping("/inactive")
    public List<Activity> getInActiveActivities() {
        return activityService.getInActiveActivities();
    }

    @GetMapping("/nastavnik/{nastavnikId}")
    public List<Activity> getNastavnikActivities(@PathVariable String nastavnikId) {
        return activityService.getActivitiesByNastavnik(nastavnikId);
    }

    @GetMapping("/activity")
    public Activity getActivityById(@RequestParam Long id){
        return activityService.getActivityById(id);
    }

    @PostMapping("/changeStatus/{id}")
    public Activity changeStatus(@PathVariable Long id){
        return activityService.changeStatus(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity addActivity(@RequestBody Map<String, Object> activityData) {
        String naziv = (String) activityData.get("naziv");
        String datum_vreme = (String) activityData.get("datum_vreme");
        Long sala1 = Long.valueOf((Integer) activityData.get("sala1"));
        Long sala2 = Long.valueOf((Integer) activityData.get("sala2"));
        Long sala3 = Long.valueOf((Integer) activityData.get("sala3"));
    
        Map<String, String> nastavnikData = (Map<String, String>) activityData.get("napravio");
        String korisnickoIme = nastavnikData.get("korisnickoIme");
        Optional<User> nastavnik = userRepository.findByKorisnickoImeAndTip(korisnickoIme, "nastavnik");
        
        if (nastavnik.isPresent()) {
            Activity activity = new Activity(naziv, datum_vreme, nastavnik.get(), 1L, sala1, sala2, sala3);
            return activityRepository.save(activity);
        } else {
            throw new IllegalArgumentException("Nastavnik sa datim korisničkim imenom ne postoji");
        }
    }
    


}
