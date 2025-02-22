package com.pato.pruebaHibernate.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "motor_id_motor", referencedColumnName = "id_motor", unique = true)
    // "un auto tendrá sólo un motor, y un motor tendrá sólo un auto"
    private Motor motor;

    @OneToMany(mappedBy = "autoPerteneciente", cascade = CascadeType.ALL,
                                                orphanRemoval = true, fetch = FetchType.LAZY)
    // en las ruedas está el atributo autoPerteneciente, que en la DB es la FK
    @JsonManagedReference
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
