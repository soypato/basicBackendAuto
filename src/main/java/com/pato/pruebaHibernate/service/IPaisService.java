package com.pato.pruebaHibernate.service;


import com.pato.pruebaHibernate.model.Pais;

import java.util.List;

public interface IPaisService {
    Pais getPais(Long id);
    List<Pais> getPaises();
    void postPais(Pais nuevoPais);
    void putPais(Pais pais);
    void deletePais(Long id);
}
