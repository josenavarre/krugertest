package com.kruger.vacunacion.app.controllers;

import com.kruger.vacunacion.app.entities.Empleado;
import com.kruger.vacunacion.app.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/all")
    public ResponseEntity<?>  index() {
        Iterable<Empleado> empleados =  empleadoService.findAll();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Empleado empleado, BindingResult result , @PathVariable Long id) {

        if(result.hasErrors())
            return validar(result);

        Optional<Empleado> o = this.empleadoService.finById(id);

        if (!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Empleado empleadoDB = o.get();
        empleadoDB.setNombres(empleado.getNombres());
        empleadoDB.setApellidos(empleado.getApellidos());
        empleadoDB.setCedula(empleado.getCedula());
        empleadoDB.setCorreo(empleado.getCorreo());

        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleadoDB));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (Long id) {
        empleadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> crear(@Valid @RequestBody  Empleado empleado, BindingResult result) {


        if(result.hasErrors())
            return validar(result);
        Empleado entityDB =  empleadoService.save(empleado);

        generarUsuario(empleado);

        return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);

    }

    private void generarUsuario(Empleado empleado) {
        String username = empleado.getNombres().charAt(0) + empleado.getApellidos().split(" ")[0];
        String password = empleado.getCedula();

        empleadoService.DarDeAltaUsuario(username,password);
    }



    protected ResponseEntity<?> validar(BindingResult result) {

        Map<String, Object> errores = new HashMap<>();


        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }

}
