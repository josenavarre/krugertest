package com.kruger.vacunacion.app.repository;

import com.kruger.vacunacion.app.entities.Dosis;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface DosisRepository extends PagingAndSortingRepository<Dosis, Long> {
}
