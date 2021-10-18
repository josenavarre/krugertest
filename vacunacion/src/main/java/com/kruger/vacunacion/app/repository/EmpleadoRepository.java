package com.kruger.vacunacion.app.repository;

import com.kruger.vacunacion.app.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface EmpleadoRepository extends PagingAndSortingRepository<Empleado, Long> {

    @Query("select e.nombres, e.apellidos from Empleado e")
    public Empleado DarDeAltaUsuario(String username, String password);
}
