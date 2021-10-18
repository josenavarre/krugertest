package com.kruger.vacunacion.app.repository;

import com.kruger.vacunacion.app.entities.TipoVacuna;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TipoVacunaRepository extends PagingAndSortingRepository<TipoVacuna, Long> {
}
