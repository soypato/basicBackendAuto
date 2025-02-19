package com.pato.pruebaHibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_motor;
    private String marca;

    public Motor() {
    }

    public Motor(Long id_motor, String marca) {
        this.id_motor = id_motor;
        this.marca = marca;
    }
}
