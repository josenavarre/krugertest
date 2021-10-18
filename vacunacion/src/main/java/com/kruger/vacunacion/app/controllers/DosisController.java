package com.kruger.vacunacion.app.controllers;

import com.kruger.vacunacion.app.entities.Dosis;
import com.kruger.vacunacion.app.entities.Empleado;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DosisController {

   // @Autowired
    //private DosisService dosisService;

    @GetMapping("/dosis")
    public ResponseEntity<?> index() {
        //Iterable<Dosis> empleados =  dosisService.findAll();
        return new ResponseEntity<>("empleados", HttpStatus.OK);
    }
}
