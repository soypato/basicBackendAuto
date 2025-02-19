package com.pato.pruebaHibernate.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.lang.ref.Reference;

@Getter @Setter
@Entity // nueva anotación!
public class Auto {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE) // nueva anotación!
    // sequence es la más usada en lo laboral
    private long id;
    private String modelo;
    private int anio;
    @OneToOne // "un auto tendrá sólo un motor, y un motor tendrá sólo un auto"
    @JoinColumn(name = "motor_id_motor", referencedColumnName = "id_motor")
    // nombre de la FK en la tabla Auto, nombre de la PK en la tabla Motor
    private Motor motor;

    public Auto(long id, String modelo, int anio) {
        this.id = id;
        this.modelo = modelo;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", motor=" + motor +
                '}';
    }

    // IMPORTANTE EL CONSTRUCTOR VACIO, QUE ES REQUERIDO
    public Auto() {

    }
}
