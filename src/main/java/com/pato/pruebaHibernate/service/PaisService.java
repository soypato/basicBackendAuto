package com.pato.pruebaHibernate.service;

import com.pato.pruebaHibernate.model.Pais;
import com.pato.pruebaHibernate.repository.IPaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService implements IPaisService {
    @Autowired // Inyectamos el repositorio
    private IPaisRepository paisRepository;

    @Override
    public void postPais(Pais nuevoPais) {
        paisRepository.save(nuevoPais);
    }

    @Override
    public Pais getPais(Long id) {
        return paisRepository.findById(id).orElse(null);
    }

    @Override
    public void putPais(Pais pais) {
        if (getPais(pais.getId()) != null) {
            paisRepository.save(pais);
        }
    }

    @Override
    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }

    @Override
    public List<Pais> getPaises() {
        return paisRepository.findAll();
    }
}