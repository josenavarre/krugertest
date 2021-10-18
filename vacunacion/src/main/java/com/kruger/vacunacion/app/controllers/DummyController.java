package com.kruger.vacunacion.app.controllers;


import com.kruger.vacunacion.app.entities.Dosis;
import com.kruger.vacunacion.app.entities.Empleado;
import com.kruger.vacunacion.app.entities.TipoVacuna;
import com.kruger.vacunacion.app.entities.Vacuna;
import com.kruger.vacunacion.app.services.DosisService;
import com.kruger.vacunacion.app.services.IEmpleadoService;
import com.kruger.vacunacion.app.services.TipoVacunaService;
import com.kruger.vacunacion.app.services.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dummy")
public class DummyController {

    @Autowired
    private IEmpleadoService empleadoService;

    @Autowired
    private DosisService dosisService;

    @Autowired
    private TipoVacunaService tipoVacunaService;


    @Autowired
    private VacunaService vacunaService;


    @GetMapping()
    public ResponseEntity<?>  empleado() {
        Empleado empleados = null;

        for (int i = 0; i < 10; i++) {
            Empleado e = new Empleado();
            e.setNombres("Empleado"+i);
            e.setApellidos("Emp Ado"+i);
            e.setCedula("A12345678"+i);
            e.setCorreo(i+"e@gmail.com");
            empleados =  empleadoService.save(e);

            System.out.println("******** E. " + i );
            int numero = (int)(Math.random()*1);

            TipoVacuna tipo = new TipoVacuna();
            tipo.setDescripcion("pfizer");
            TipoVacuna tipobd = tipoVacunaService.save(tipo);

            System.out.println("******** T. " + i );

            String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());


            Dosis dosis = new Dosis();
            dosis.setNroDosis(numero);
            dosis.setFecVacuna(timeStamp);
            dosis.setTipoVacuna(tipobd);
            Dosis dosis2=  dosisService.save(dosis);
            System.out.println("******** D. " + i );



            Vacuna vacuna = new Vacuna();
            vacuna.setEmpleado(empleados);
            vacuna.setDireccion("Casa ");
            vacuna.setEstado(numero);
            vacuna.setTelefono("3223");
            vacuna.setFechaNac("14/10/1990");
            vacuna.addDosis(dosis2);

            Vacuna vac = vacunaService.save(vacuna);

            System.out.println("******** V. " + vac );
        }

        System.out.println("Se regitrador 10 empleados");
        return ResponseEntity.status(HttpStatus.CREATED).body(empleados);

    }


    @GetMapping("/dosis")
    public ResponseEntity<?>  dosis() {

        Iterable<Dosis>  dosisList = dosisService.findAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(dosisList);

    }

    @GetMapping("/vacunas")
    public ResponseEntity<?>  vacunas() {

        Iterable<Vacuna>  dosisList = vacunaService.findAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(dosisList);

    }

}
