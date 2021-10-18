package com.kruger.vacunacion.app.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacunas")
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fechaNac;
    private String direccion;
    private String telefono;
    private int estado;

    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Dosis> dosis;

    public Vacuna() {
        this.dosis = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Dosis> getDosis() {
        return dosis;
    }

    public void setDosis(List<Dosis> dosis) {
        this.dosis = dosis;
    }


    public void removeDosis(Dosis dosis) {
        this.dosis.remove(dosis);

    }
    public void addDosis(Dosis dosis) {
        this.dosis.add(dosis);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(!(obj instanceof Dosis))
            return false;
        Dosis a = (Dosis)obj;
        return this.id != null && this.id.equals(a.getId());
    }
}
