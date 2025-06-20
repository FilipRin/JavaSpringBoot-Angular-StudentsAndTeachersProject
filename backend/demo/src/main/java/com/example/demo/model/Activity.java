package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "aktivnosti")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String datum_vreme;
    
    //napravio nastavnik koji je foreign key u tabebli aktivnosti
    @ManyToOne
    @JoinColumn(name = "napravio", referencedColumnName = "korisnicko_ime")
    private User nastavnik;

    private Long status;
    private Long sala1;
    private Long sala2;
    private Long sala3;

    public Activity() {
    }

    public Activity(String naziv, String datum_vreme, User nastavnik, Long status, Long sala1, Long sala2, Long sala3) {
        this.naziv = naziv;
        this.datum_vreme = datum_vreme;
        this.nastavnik = nastavnik;
        this.status = status;
        this.sala1 = sala1;
        this.sala2 = sala2;
        this.sala3 = sala3;
    }

}
