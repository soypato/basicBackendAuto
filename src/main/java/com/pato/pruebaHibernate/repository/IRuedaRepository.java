package com.pato.pruebaHibernate.repository;

import com.pato.pruebaHibernate.model.Rueda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRuedaRepository extends JpaRepository<Rueda, Long> {
}
