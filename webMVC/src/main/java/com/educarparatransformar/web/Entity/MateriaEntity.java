package com.educarparatransformar.web.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "materia")
public class MateriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "profesores_materias",
            joinColumns = @JoinColumn(name = "materia_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private List<ProfesorEntity> profesores;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorarioEntity> horarios;
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CalificacionEntity> calificaciones;

    public MateriaEntity() {
    }

    public MateriaEntity(long id, String nombre, List<ProfesorEntity> profesores, CursoEntity curso, List<HorarioEntity> horarios) {
        this.id = id;
        this.nombre = nombre;
        this.profesores = profesores;
        this.curso = curso;
        this.horarios = horarios;
    }

    public MateriaEntity(long id, String nombre, CursoEntity curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        profesores = new ArrayList<>();
        horarios = new ArrayList<>();
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

    public List<ProfesorEntity> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<ProfesorEntity> profesores) {
        this.profesores = profesores;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    public List<HorarioEntity> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntity> horarios) {
        this.horarios = horarios;
    }

    public List<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MateriaEntity that = (MateriaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(profesores, that.profesores) && Objects.equals(curso, that.curso) && Objects.equals(horarios, that.horarios) && Objects.equals(calificaciones, that.calificaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, profesores, curso, horarios, calificaciones);
    }

    @Override
    public String toString() {
        return "MateriaEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesores=" + profesores +
                ", curso=" + curso +
                ", horarios=" + horarios +
                ", calificaciones=" + calificaciones +
                '}';
    }
}
