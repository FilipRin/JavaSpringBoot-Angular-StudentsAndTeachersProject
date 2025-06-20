package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prijave")
@IdClass(PrijavaId.class)
public class Prijava {

    @Id
    @ManyToOne
    @JoinColumn(name = "student", referencedColumnName = "korisnicko_ime")
    private User student;

    @Id
    @ManyToOne
    @JoinColumn(name = "aktivnost", referencedColumnName = "id")
    private Activity aktivnost;

    @Id
    @ManyToOne
    @JoinColumn(name = "sala", referencedColumnName = "naziv")
    private Sala sala;
}
