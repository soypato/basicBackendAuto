package com.pato.pruebaHibernate.service;

import com.pato.pruebaHibernate.model.Auto;
import com.pato.pruebaHibernate.repository.IAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAutoService {
    public void createAuto(Auto autoNuevo); // create - post
    public Auto getAuto(Long id); // read - get
    public void updateAuto(Long id, String modelo, int anio); // update
    public void deleteAuto(Long id); // delete

    public List<Auto> getAutos(); // read - get

}
