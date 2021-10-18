package com.kruger.vacunacion.app.services;

import com.kruger.vacunacion.app.entities.Dosis;
import com.kruger.vacunacion.app.entities.Empleado;
import com.kruger.vacunacion.app.entities.Vacuna;

import java.util.List;

public interface VacunaService extends CommonService<Vacuna> {

    public List<Vacuna> listarPorEstado(Long estado);
    public List<Dosis> listarPorTipo(Long tipo);
    public List<Dosis> listarPorRangoFEchas(String fec1, String fec2);
}
