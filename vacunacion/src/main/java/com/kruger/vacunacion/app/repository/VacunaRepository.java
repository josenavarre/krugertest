package com.kruger.vacunacion.app.repository;


import com.kruger.vacunacion.app.entities.Dosis;
import com.kruger.vacunacion.app.entities.Vacuna;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface VacunaRepository extends PagingAndSortingRepository<Vacuna, Long>  {

    @Query("select e, v.estado from Vacuna v inner JOIN Empleado e on v.empleado.id = e.id where v.estado =?1")
    public List<Vacuna> listarPorEstado(Long estado);

    @Query("select d from Dosis d  where d.tipoVacuna.id =?1")
    public List<Dosis> listarPorTipo(Long tipo);

    @Query("select d from Dosis d  where d.fecVacuna between ?1 and ?2 ")
    public List<Dosis> listarPorRangoFEchas(String fec1, String fec2);
}
