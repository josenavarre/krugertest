package com.kruger.vacunacion.app.entities;


import javax.persistence.*;

@Entity
@Table(name = "dosis")
public class Dosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecVacuna;
    private int nroDosis;
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoVacuna tipoVacuna;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecVacuna() {
        return fecVacuna;
    }

    public void setFecVacuna(String fecVacuna) {
        this.fecVacuna = fecVacuna;
    }

    public int getNroDosis() {
        return nroDosis;
    }

    public void setNroDosis(int nroDosis) {
        this.nroDosis = nroDosis;
    }

    public TipoVacuna getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(TipoVacuna tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }
}
