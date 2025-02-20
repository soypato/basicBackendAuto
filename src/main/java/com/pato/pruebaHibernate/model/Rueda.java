package com.pato.pruebaHibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Rueda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idRueda;

    private String nombreRueda;
    private int posicion;

    @ManyToOne
    @JoinColumn(name="auto_id")
    @JsonIgnore
    private Auto autoPerteneciente;

    public Rueda() {
    }
}
