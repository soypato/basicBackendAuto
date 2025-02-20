package com.pato.pruebaHibernate.service;

import com.pato.pruebaHibernate.model.Rueda;
import com.pato.pruebaHibernate.repository.IRuedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuedaService implements IRuedaService {
    @Autowired // Inyecto el repositorio
    private IRuedaRepository ruedaRepository;

    @Override
    public void postRueda(Rueda nuevaRueda) {
        ruedaRepository.save(nuevaRueda);
    }

    @Override
    public Rueda getRueda(Long id) {
        return ruedaRepository.findById(id).orElse(null);
    }

    @Override
    public void putRueda(Rueda rueda) {
        if (getRueda(rueda.getIdRueda()) != null) {
            ruedaRepository.save(rueda);
        }
    }

    @Override
    public void deleteRueda(Long id) {
        ruedaRepository.deleteById(id);
    }

    @Override
    public List<Rueda> getRuedas() {
        return ruedaRepository.findAll();
    }
}