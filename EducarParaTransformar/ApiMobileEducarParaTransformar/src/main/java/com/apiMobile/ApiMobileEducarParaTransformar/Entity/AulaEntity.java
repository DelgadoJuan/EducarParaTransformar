package com.apiMobile.ApiMobileEducarParaTransformar.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "aula")
public class AulaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private CursoEntity curso;
    private String nombre;

    public AulaEntity() {
    }

    public AulaEntity(String nombre) {
        this.nombre = nombre;
    }

    public AulaEntity(CursoEntity curso, String nombre) {
        this.curso = curso;
        this.nombre = nombre;
    }

    public AulaEntity(Long id, CursoEntity curso, String nombre) {
        this.id = id;
        this.curso = curso;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AulaEntity that = (AulaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(curso, that.curso) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, curso, nombre);
    }

    @Override
    public String toString() {
        return "AulaEntity{" +
                "id=" + id +
                ", curso=" + curso +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
