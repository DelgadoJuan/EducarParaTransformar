package com.desktop.DesktopApp.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "materias")
public class MateriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProfesorEntity profesor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CalificacionEntity> calificaciones = new ArrayList<>();
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<HorarioEntity> horarios;

    public MateriaEntity() {
    }

    public MateriaEntity(Long id, String nombre, ProfesorEntity profesor, CursoEntity curso, List<CalificacionEntity> calificaciones, List<HorarioEntity> horarios) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
        this.curso = curso;
        this.calificaciones = calificaciones;
        this.horarios = horarios;
    }

    public MateriaEntity(String nombre, CursoEntity curso) {
        this.nombre = nombre;
        this.curso = curso;
        this.calificaciones = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    public ProfesorEntity getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorEntity profesor) {
        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    public List<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public List<HorarioEntity> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntity> horarios) {
        this.horarios = horarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MateriaEntity materia = (MateriaEntity) o;
        return Objects.equals(id, materia.id) && Objects.equals(nombre, materia.nombre) && Objects.equals(profesor, materia.profesor) && Objects.equals(curso, materia.curso) && Objects.equals(calificaciones, materia.calificaciones) && Objects.equals(horarios, materia.horarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, profesor, curso, calificaciones, horarios);
    }

    @Override
    public String toString() {
        return "MateriaEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + profesor +
                ", curso=" + curso +
                ", calificaciones=" + calificaciones +
                ", horarios=" + horarios +
                '}';
    }
}
