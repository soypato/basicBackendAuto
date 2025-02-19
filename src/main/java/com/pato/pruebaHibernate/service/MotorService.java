package com.pato.pruebaHibernate.service;

import com.pato.pruebaHibernate.model.Motor;
import com.pato.pruebaHibernate.repository.IMotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorService implements IMotorService {
    @Autowired
    private IMotorRepository motorRepository;

    @Override
    public Motor getMotor(Long id) {
        Optional<Motor> motorOptional = motorRepository.findById(id);
        return motorOptional.orElse(null);  // Devolver el motor si está presente, o null si no lo está.
    }


    @Override
    public List<Motor> getMotores() {
        return motorRepository.findAll();
    }

    @Override
    public void postMotor(Motor nuevoMotor) {
        motorRepository.save(nuevoMotor);
    }

    @Override
    public void putMotor(Long id, String marca) {
        Motor res = getMotor(id);
        if(res != null)
        {
            res.setMarca(marca);
            motorRepository.save(res);
        }
    }

    @Override
    public void deleteMotor(Long id) {
        motorRepository.deleteById(id);
    }
}
