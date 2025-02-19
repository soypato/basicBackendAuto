package com.pato.pruebaHibernate.service;

import com.pato.pruebaHibernate.model.Auto;
import com.pato.pruebaHibernate.repository.IAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService implements IAutoService {
    @Autowired // inyecto el repositorio
    private IAutoRepository autoRepository;


    @Override
    public void createAuto(Auto autoNuevo) {
        autoRepository.save(autoNuevo);
    }

    @Override
    public Auto getAuto(Long id) {
        return autoRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAuto(Auto auto) {
        if(getAuto(auto.getId()) != null)
        {
            autoRepository.save(auto);
        }
    }

    @Override
    public void deleteAuto(Long id) {
        autoRepository.deleteById(id);
    }

    @Override
    public List<Auto> getAutos() {
        return autoRepository.findAll();
    }
}
