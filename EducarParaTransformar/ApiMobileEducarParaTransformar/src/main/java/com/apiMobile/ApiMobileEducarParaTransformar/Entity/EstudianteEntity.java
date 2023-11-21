package com.apiMobile.ApiMobileEducarParaTransformar.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiante")
public class EstudianteEntity extends UsuarioEntity {
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CalificacionEntity> calificaciones;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    private TitularEntity titular;

    public EstudianteEntity() {
    }

    public EstudianteEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento,
                            Roles rol, CursoEntity curso) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        this.calificaciones = new ArrayList<>();
        this.curso = curso;
    }

    public EstudianteEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento,
                            Roles rol, List<CalificacionEntity> calificaciones, CursoEntity curso, TitularEntity titular) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        this.titular = titular;
        this.calificaciones = calificaciones;
        this.curso = curso;
    }

    public EstudianteEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento, Roles rol) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        this.calificaciones = new ArrayList<>();
    }

    public List<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    public TitularEntity getTitular() {
        return titular;
    }

    public void setTitular(TitularEntity titular) {
        this.titular = titular;
    }
}
