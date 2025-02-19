package com.pato.pruebaHibernate.service;

import com.pato.pruebaHibernate.model.Motor;

import java.util.List;

public interface IMotorService {
    Motor getMotor(Long id);
    List<Motor> getMotores();
    void postMotor(Motor nuevoMotor);
    void putMotor(Long id, String marca);
    void deleteMotor(Long id);
}
