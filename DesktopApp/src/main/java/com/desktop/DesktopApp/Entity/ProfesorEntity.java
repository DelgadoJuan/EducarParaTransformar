package com.desktop.DesktopApp.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "profesor")
public class ProfesorEntity extends UsuarioEntity{
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<MateriaEntity> materias;

    public ProfesorEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento, Roles rol, List<MateriaEntity> materias) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        this.materias = materias;
    }

    public ProfesorEntity(String username, String nombre, String email, String password, LocalDate fechaNacimiento, Roles rol) {
        super(username, nombre, email, password, fechaNacimiento, rol);
        materias = new ArrayList<>();
    }

    public ProfesorEntity() {
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
        if (!super.equals(o)) return false;
        ProfesorEntity that = (ProfesorEntity) o;
        return Objects.equals(materias, that.materias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), materias);
    }

    @Override
    public String toString() {
        return "ProfesorEntity{" +
                "materias=" + materias +
                '}';
    }
}
