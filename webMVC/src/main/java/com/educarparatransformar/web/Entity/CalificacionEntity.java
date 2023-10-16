package com.educarparatransformar.web.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "calificacion")
public class CalificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nota;
    private String descripcion;
    @ManyToOne
    private EstudianteEntity alumno;
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private MateriaEntity materia;

    public CalificacionEntity() {
    }

    public CalificacionEntity(long id, int nota, String descripcion, EstudianteEntity alumno, MateriaEntity materia) {
        this.id = id;
        this.nota = nota;
        this.descripcion = descripcion;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstudianteEntity getAlumno() {
        return alumno;
    }

    public void setAlumno(EstudianteEntity alumno) {
        this.alumno = alumno;
    }

    public MateriaEntity getMateria() {
        return materia;
    }

    public void setMateria(MateriaEntity materia) {
        this.materia = materia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalificacionEntity that = (CalificacionEntity) o;
        return nota == that.nota && Objects.equals(id, that.id) && Objects.equals(descripcion, that.descripcion) && Objects.equals(alumno, that.alumno) && Objects.equals(materia, that.materia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nota, descripcion, alumno, materia);
    }

    @Override
    public String toString() {
        return "CalificacionEntity{" +
                "id=" + id +
                ", nota=" + nota +
                ", descripcion='" + descripcion + '\'' +
                ", alumno=" + alumno +
                ", materia=" + materia +
                '}';
    }
}
