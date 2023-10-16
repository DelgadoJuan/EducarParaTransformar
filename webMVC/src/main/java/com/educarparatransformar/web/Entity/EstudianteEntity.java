package com.educarparatransformar.web.Entity;

import com.educarparatransformar.web.DTO.Roles;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "estudiante")
public class EstudianteEntity extends UsuarioEntity {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CalificacionEntity> calificaciones;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;

    public EstudianteEntity() {
    }

    public EstudianteEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento, Roles rol) {
        super(username, nombre, email, password, fechaNacimiento, rol);
    }

    public EstudianteEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento,
                            Roles rol, CursoEntity curso) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        calificaciones = new ArrayList<>();
        this.curso = curso;
    }

    public EstudianteEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento,
                            Roles rol, List<CalificacionEntity> calificaciones, CursoEntity curso) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        this.calificaciones = calificaciones;
        this.curso = curso;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EstudianteEntity that = (EstudianteEntity) o;
        return Objects.equals(calificaciones, that.calificaciones) && Objects.equals(curso, that.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), calificaciones, curso);
    }

    @Override
    public String toString() {
        return "EstudianteEntity{" +
                "calificaciones=" + calificaciones +
                ", curso=" + curso +
                '}';
    }
}
