package com.educarparatransformar.web.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "horario")
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String turno;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private MateriaEntity materia;

    public HorarioEntity() {
    }

    public HorarioEntity(String turno, LocalDateTime inicio, LocalDateTime fin) {
        this.turno = turno;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
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
        HorarioEntity that = (HorarioEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(turno, that.turno) && Objects.equals(inicio, that.inicio) && Objects.equals(fin, that.fin) && Objects.equals(materia, that.materia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, turno, inicio, fin, materia);
    }

    @Override
    public String toString() {
        return "HorarioEntity{" +
                "id=" + id +
                ", turno='" + turno + '\'' +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", materia=" + materia +
                '}';
    }
}
