package com.pato.pruebaHibernate.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "auto_pais",
            // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "auto_id", nullable = false),
            // así se llamará la FK de Auto en la tabla intermedia
            inverseJoinColumns = @JoinColumn(name = "pais_id", nullable = false)
            // así se llamará la FK de País en la tabla intermedia
            // nullable = false es que no puede ser nulo en la base de datos el valor
    )
    private Set<Pais> paisesHabilitados;



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
