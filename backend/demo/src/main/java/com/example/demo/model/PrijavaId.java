package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class PrijavaId implements Serializable {

    private String student;
    private Long aktivnost;
    private String sala;

    public PrijavaId() {}

    public PrijavaId(String student, Long aktivnost, String sala) {
        this.student = student;
        this.aktivnost = aktivnost;
        this.sala = sala;
    }

    public String getStudent() { return student; }
    public void setStudent(String student) { this.student = student; }

    public Long getAktivnost() { return aktivnost; }
    public void setAktivnost(Long aktivnost) { this.aktivnost = aktivnost; }

    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrijavaId prijavaId = (PrijavaId) o;
        return Objects.equals(student, prijavaId.student) &&
               Objects.equals(aktivnost, prijavaId.aktivnost) &&
               Objects.equals(sala, prijavaId.sala);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, aktivnost, sala);
    }
}
