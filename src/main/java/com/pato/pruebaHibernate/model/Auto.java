package com.pato.pruebaHibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity // nueva anotación!
public class Auto {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE) // nueva anotación!
    // sequence es la más usada en lo laboral
    private long id;
    private String modelo;
    private int anio;

    public Auto(long id, String modelo, int anio) {
        this.id = id;
        this.modelo = modelo;
        this.anio = anio;
    }
    // IMPORTANTE EL CONSTRUCTOR VACIO, QUE ES REQUERIDO
    public Auto() {

    }
}
