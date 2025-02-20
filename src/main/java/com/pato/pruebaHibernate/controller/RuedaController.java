package com.pato.pruebaHibernate.controller;

import com.pato.pruebaHibernate.model.Rueda;
import com.pato.pruebaHibernate.service.RuedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ruedas") // Definimos la ruta base para los endpoints de este controlador
public class RuedaController {

    @Autowired
    private RuedaService ruedaService;

    @GetMapping("/get")
    public ResponseEntity<List<Rueda>> getRuedas() {
        List<Rueda> ruedas = ruedaService.getRuedas();
        return new ResponseEntity<>(ruedas, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Rueda> getRueda(@PathVariable Long id) {
        Rueda rueda = ruedaService.getRueda(id);
        return rueda != null ? new ResponseEntity<>(rueda, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postRueda(@RequestBody Rueda rueda) {
        ruedaService.postRueda(rueda);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Rueda> putRueda(@RequestBody Rueda rueda) {
        ruedaService.putRueda(rueda);
        return new ResponseEntity<>(ruedaService.getRueda(rueda.getIdRueda()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRueda(@PathVariable Long id) {
        ruedaService.deleteRueda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
