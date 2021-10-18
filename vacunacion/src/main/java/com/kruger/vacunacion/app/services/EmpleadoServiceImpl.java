package com.kruger.vacunacion.app.services;

import com.kruger.vacunacion.app.entities.Empleado;
import com.kruger.vacunacion.app.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl extends CommonServiceImpl<Empleado, EmpleadoRepository> implements IEmpleadoService{



    @Autowired
    private EmpleadoRepository repo;


    @Override
    public Empleado DarDeAltaUsuario(String username, String password) {
        return repo.DarDeAltaUsuario(username,password);
    }
}
