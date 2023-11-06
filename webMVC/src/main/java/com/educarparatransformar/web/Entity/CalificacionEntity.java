package com.educarparatransformar.web.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "calificacion")
public class CalificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nota;
    private String descripcion;
    @ManyToOne(fetch = FetchType.EAGER)
    private EstudianteEntity alumno;
    @ManyToOne(fetch = FetchType.EAGER)
    private MateriaEntity materia;

    public CalificacionEntity() {
    }

    public CalificacionEntity(int nota, String descripcion, EstudianteEntity alumno, MateriaEntity materia) {
        this.nota = nota;
        this.descripcion = descripcion;
        this.alumno = alumno;
        this.materia = materia;
    }

    public CalificacionEntity(int nota, String descripcion, MateriaEntity materia) {
        this.nota = nota;
        this.descripcion = descripcion;
        this.materia = materia;
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
}
