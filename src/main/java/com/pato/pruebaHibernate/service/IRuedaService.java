package com.pato.pruebaHibernate.service;

import com.pato.pruebaHibernate.model.Rueda;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRuedaService {
    Rueda getRueda(Long id);
    List<Rueda> getRuedas();
    void postRueda(Rueda nuevaRueda);
    void putRueda(Rueda rueda);
    void deleteRueda(Long id);
}
