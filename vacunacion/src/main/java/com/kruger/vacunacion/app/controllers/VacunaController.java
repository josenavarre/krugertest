package com.kruger.vacunacion.app.controllers;



import com.kruger.vacunacion.app.entities.Dosis;
import com.kruger.vacunacion.app.entities.Vacuna;

import com.kruger.vacunacion.app.services.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vacuna")
public class VacunaController {

    @Autowired
    private VacunaService service;

    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> estado(@PathVariable Long estado) {

        Iterable<Vacuna> vacunase =  service.listarPorEstado(estado);

        return new ResponseEntity<>(vacunase, HttpStatus.OK);
    }
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<?> tipo(@PathVariable Long tipo) {

        Iterable<Dosis> vacunas =  service.listarPorTipo(tipo);
        return new ResponseEntity<>(vacunas, HttpStatus.OK);
    }
    @GetMapping("/ranfofechas/{fec1}/{fec2}")
    public ResponseEntity<?> fechas(@PathVariable  String fec1,@PathVariable  String fec2) {


        Iterable<Dosis> vacunas =  service.listarPorRangoFEchas(fec1,fec2);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
