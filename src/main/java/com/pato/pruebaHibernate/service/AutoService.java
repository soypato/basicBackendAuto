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
    public void updateAuto(Long id, String modelo, int anio) {
        Auto modificado = getAuto(id); // busco en la DB
        if(modificado != null) // si existe
        { // modifico con setters y getters en local
            modificado.setModelo(modelo);
            modificado.setAnio(anio);
            // Guardo los cambios en la DB
            autoRepository.save(modificado);
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
