package com.pato.pruebaHibernate.controller;

import com.pato.pruebaHibernate.model.Pais;
import com.pato.pruebaHibernate.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises") // Definimos la ruta base para los endpoints de este controlador
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/get")
    public ResponseEntity<List<Pais>> getPaises() {
        List<Pais> paises = paisService.getPaises();
        return new ResponseEntity<>(paises, HttpStatus.OK);
        // Devolvemos la lista completa de países en formato JSON y un código HTTP 200 (OK)
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Pais> getPais(@PathVariable Long id) {
        Pais pais = paisService.getPais(id);
        return pais != null ? new ResponseEntity<>(pais, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // Devolvemos el país solicitado si existe, en caso contrario, respondemos con 404 (Not Found)
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postPais(@RequestBody Pais pais) {
        paisService.postPais(pais);
        return new ResponseEntity<>(HttpStatus.CREATED);
        // Creamos un nuevo país y respondemos con 201 (Created), sin necesidad de devolver el objeto
    }

    @PutMapping("/edit")
    public ResponseEntity<Pais> putPais(@RequestBody Pais pais) {
        paisService.putPais(pais);
        return new ResponseEntity<>(paisService.getPais(pais.getId()), HttpStatus.OK);
        // Modificamos el país con los nuevos datos y devolvemos el objeto actualizado con 200 (OK)
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        paisService.deletePais(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // Eliminamos el país y respondemos con 204 (No Content), ya que no es necesario devolver un cuerpo
    }
}
