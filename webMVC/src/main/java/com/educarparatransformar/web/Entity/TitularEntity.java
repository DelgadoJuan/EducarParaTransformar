package com.educarparatransformar.web.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TitularEntity extends UsuarioEntity{
    @OneToOne(fetch = FetchType.EAGER)
    private EstudianteEntity hijo;
    @OneToMany(mappedBy = "titular", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PagoEntity> cuotasPagadas;

    public TitularEntity() {
    }

    public TitularEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento, Roles rol) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        this.cuotasPagadas = new ArrayList<>();
    }

    public TitularEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento, Roles rol, EstudianteEntity hijo) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        this.hijo = hijo;
        this.cuotasPagadas = new ArrayList<>();
    }

    public TitularEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento, Roles rol, EstudianteEntity hijo, List<PagoEntity> cuotasPagadas) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        this.hijo = hijo;
        this.cuotasPagadas = cuotasPagadas;
    }

    public EstudianteEntity getHijo() {
        return hijo;
    }

    public void setHijo(EstudianteEntity hijo) {
        this.hijo = hijo;
    }
}
