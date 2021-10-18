package com.kruger.vacunacion.app.services;



import com.kruger.vacunacion.app.entities.TipoVacuna;

import com.kruger.vacunacion.app.repository.TipoVacunaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoVacunaServiceImpl extends CommonServiceImpl<TipoVacuna, TipoVacunaRepository> implements TipoVacunaService  {
}
