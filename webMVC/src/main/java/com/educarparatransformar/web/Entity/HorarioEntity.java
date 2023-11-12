package com.educarparatransformar.web.Entity;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;

@Entity
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private MateriaEntity materia;
    private Dia dia;
    private LocalTime inicio;
    private LocalTime fin;

    public HorarioEntity() {
    }

    public HorarioEntity(MateriaEntity materia, Dia dia, LocalTime inicio, LocalTime fin) {
        this.materia = materia;
        this.dia = dia;
        this.inicio = inicio;
        this.fin = fin;
    }

    public HorarioEntity(Long id, MateriaEntity materia, Dia dia, LocalTime inicio, LocalTime fin) {
        this.id = id;
        this.materia = materia;
        this.dia = dia;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MateriaEntity getMateria() {
        return materia;
    }

    public void setMateria(MateriaEntity materia) {
        this.materia = materia;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioEntity that = (HorarioEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(materia, that.materia) && dia == that.dia && Objects.equals(inicio, that.inicio) && Objects.equals(fin, that.fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, materia, dia, inicio, fin);
    }

    @Override
    public String toString() {
        return "HorarioEntity{" +
                "id=" + id +
                ", materia=" + materia +
                ", dia=" + dia +
                ", inicio=" + inicio +
                ", fin=" + fin +
                '}';
    }
}
