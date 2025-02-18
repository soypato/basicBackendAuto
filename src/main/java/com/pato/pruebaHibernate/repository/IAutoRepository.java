package com.pato.pruebaHibernate.repository;

import com.pato.pruebaHibernate.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // esta interfaz actuará como repository
// porque el repository ya no es necesario (ya que JpaRepository lo reemplaza)
public interface IAutoRepository extends JpaRepository<Auto, Long> {
    // JpaRepository ya contiene las operaciones básicas
    // nos pide la clase a mapear, y el tipo de dato del @Id / PK

}
