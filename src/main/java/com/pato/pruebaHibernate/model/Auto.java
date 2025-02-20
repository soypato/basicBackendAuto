package com.pato.pruebaHibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    private String modelo;
    private int anio;

    @OneToOne
    @JoinColumn(name = "id_motor", referencedColumnName = "id_motor") // Aquí referenciamos correctamente
    private Motor motor;

    @OneToMany(mappedBy = "autoPerteneciente")
    private List<Rueda> ruedas;

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", motor_id=" + (motor != null ? motor.getId_motor() : "null") +
                '}';
    }

    public Auto() {
    }
}
