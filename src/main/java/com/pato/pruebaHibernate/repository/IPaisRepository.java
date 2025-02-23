package com.pato.pruebaHibernate.repository;

import com.pato.pruebaHibernate.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisRepository extends JpaRepository<Pais, Long> {
}
