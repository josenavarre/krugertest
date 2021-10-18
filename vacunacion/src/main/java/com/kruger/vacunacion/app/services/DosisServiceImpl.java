package com.kruger.vacunacion.app.services;

import com.kruger.vacunacion.app.entities.Dosis;
import com.kruger.vacunacion.app.entities.Empleado;
import com.kruger.vacunacion.app.repository.DosisRepository;
import com.kruger.vacunacion.app.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;



@Service
public class DosisServiceImpl extends CommonServiceImpl<Dosis, DosisRepository> implements DosisService  {
}
