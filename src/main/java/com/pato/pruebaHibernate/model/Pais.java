package com.pato.pruebaHibernate.model;

import com.pato.pruebaHibernate.model.Auto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "paisesHabilitados")
    private Set<Auto> autosHabilitados;
    // Indica que Pais NO crea una tabla intermedia, sino que usa la que Auto ya definió.
    // paisesHabilitados es el nombre del atributo en Auto que define la relación.

}
