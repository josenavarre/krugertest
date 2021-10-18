package com.kruger.vacunacion.app.services;


import com.kruger.vacunacion.app.entities.Dosis;
import com.kruger.vacunacion.app.entities.Vacuna;

import com.kruger.vacunacion.app.repository.VacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacunaServiceImpl extends CommonServiceImpl<Vacuna, VacunaRepository> implements VacunaService{


    @Autowired
    private VacunaRepository repo;
    @Override
    public List<Vacuna> listarPorEstado(Long estado) {
        return repo.listarPorEstado(estado);
    }

    @Override
    public List<Dosis> listarPorTipo(Long tipo) {
        return repo.listarPorTipo(tipo);
    }

    @Override
    public List<Dosis> listarPorRangoFEchas(String fec1, String fec2) {
        return repo.listarPorRangoFEchas(fec1,fec2);
    }
}
