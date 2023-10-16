package com.educarparatransformar.web.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "curso")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String año;
    private String seccion;
    @OneToMany(mappedBy = "curso", orphanRemoval = true)
    private List<EstudianteEntity> alumnosInscriptos;
    private Nivel nivel;
    @OneToMany(mappedBy = "curso", orphanRemoval = true)
    private List<MateriaEntity> materias;

    public CursoEntity() {
    }

    public CursoEntity(long id, String año, String seccion, List<EstudianteEntity> alumnosInscriptos, Nivel nivel, List<MateriaEntity> materias) {
        this.id = id;
        this.año = año;
        this.seccion = seccion;
        this.alumnosInscriptos = alumnosInscriptos;
        this.nivel = nivel;
        this.materias = materias;
    }

    public CursoEntity(long id, String año, String seccion, Nivel nivel) {
        this.id = id;
        this.año = año;
        this.seccion = seccion;
        this.nivel = nivel;
        materias = new ArrayList<>();
        alumnosInscriptos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public List<EstudianteEntity> getAlumnosInscriptos() {
        return alumnosInscriptos;
    }

    public void setAlumnosInscriptos(List<EstudianteEntity> alumnosInscriptos) {
        this.alumnosInscriptos = alumnosInscriptos;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<MateriaEntity> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaEntity> materias) {
        this.materias = materias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoEntity that = (CursoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(año, that.año) && Objects.equals(seccion, that.seccion) && Objects.equals(alumnosInscriptos, that.alumnosInscriptos) && nivel == that.nivel && Objects.equals(materias, that.materias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, año, seccion, alumnosInscriptos, nivel, materias);
    }

    @Override
    public String toString() {
        return "CursoEntity{" +
                "id=" + id +
                ", año='" + año + '\'' +
                ", seccion='" + seccion + '\'' +
                ", alumnosInscriptos=" + alumnosInscriptos +
                ", nivel=" + nivel +
                ", materias=" + materias +
                '}';
    }
}
