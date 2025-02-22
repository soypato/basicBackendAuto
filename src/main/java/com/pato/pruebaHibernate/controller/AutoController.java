package com.pato.pruebaHibernate.controller;

import com.pato.pruebaHibernate.model.Auto;
import com.pato.pruebaHibernate.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autos") // Definimos la ruta base para los endpoints de este controlador
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping("/get")
    public ResponseEntity<List<Auto>> getAutos() {
        List<Auto> autos = autoService.getAutos();
        return new ResponseEntity<>(autos, HttpStatus.OK);
        // Devolvemos la lista completa de autos en formato JSON y un código HTTP 200 (OK)
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Auto> getAuto(@PathVariable Long id) {
        Auto auto = autoService.getAuto(id);
        return auto != null ? new ResponseEntity<>(auto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // Devolvemos el auto solicitado si existe, en caso contrario, respondemos con 404 (Not Found)
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postAuto(@RequestBody Auto auto) {
        autoService.createAuto(auto);
        return new ResponseEntity<>(HttpStatus.CREATED);
        // Creamos un nuevo auto y respondemos con 201 (Created), sin necesidad de devolver el objeto
    }

    @PutMapping("/edit")
    public ResponseEntity<Auto> putAuto(@RequestBody Auto auto) {
        autoService.updateAuto(auto);
        return new ResponseEntity<>(autoService.getAuto(auto.getId()), HttpStatus.OK);
        // Modificamos el auto con los nuevos datos y devolvemos el objeto actualizado con 200 (OK)
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuto(@PathVariable Long id) {
        autoService.deleteAuto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // Eliminamos el auto y respondemos con 204 (No Content), ya que no es necesario devolver un cuerpo
    }
}



