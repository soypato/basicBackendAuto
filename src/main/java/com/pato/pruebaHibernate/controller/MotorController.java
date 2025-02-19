package com.pato.pruebaHibernate.controller;

import com.pato.pruebaHibernate.model.Auto;
import com.pato.pruebaHibernate.model.Motor;
import com.pato.pruebaHibernate.service.AutoService;
import com.pato.pruebaHibernate.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motores")
public class MotorController {
    @Autowired
    MotorService motorService;

    @GetMapping("/get")
    public ResponseEntity<List<Motor>> getMotores() {
        return new ResponseEntity<>(motorService.getMotores(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Motor> getMotor(@PathVariable Long id) {
        Motor motor = motorService.getMotor(id);
        return motor != null ? new ResponseEntity<>(motor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // Devolvemos el auto solicitado si existe, en caso contrario, respondemos con 404 (Not Found)
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postAuto(@RequestBody Motor motor) {
        motorService.postMotor(motor);
        return new ResponseEntity<>(HttpStatus.CREATED);
        // Creamos un nuevo auto y respondemos con 201 (Created), sin necesidad de devolver el objeto
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Motor> putAuto(@PathVariable Long id, @RequestBody Motor motor) {
        motorService.putMotor(motor.getId_motor(), motor.getMarca());
        return new ResponseEntity<>(motorService.getMotor(id), HttpStatus.OK);
        // Modificamos el auto con los nuevos datos y devolvemos el objeto actualizado con 200 (OK)
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuto(@PathVariable Long id) {
        motorService.deleteMotor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // Eliminamos el auto y respondemos con 204 (No Content), ya que no es necesario devolver un cuerpo
    }
}