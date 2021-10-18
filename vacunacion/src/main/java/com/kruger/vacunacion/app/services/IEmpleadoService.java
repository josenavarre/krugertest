package com.kruger.vacunacion.app.services;

import com.kruger.vacunacion.app.entities.Empleado;


public interface IEmpleadoService   extends CommonService<Empleado> {
    public Empleado DarDeAltaUsuario(String username, String password);
}
