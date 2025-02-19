package com.pato.pruebaHibernate.repository;

import com.pato.pruebaHibernate.model.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMotorRepository extends JpaRepository<Motor, Long> {
}
