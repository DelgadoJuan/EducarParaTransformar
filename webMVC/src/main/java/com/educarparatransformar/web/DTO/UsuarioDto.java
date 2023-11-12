package com.educarparatransformar.web.DTO;

import com.educarparatransformar.web.Entity.Roles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class UsuarioDto {
    private String username;
    private String email;
    private String nombre;
    private String password;
    private Roles rol;
    private LocalDate fechaNacimiento;

    public UsuarioDto() {
    }

    public UsuarioDto(String username, String email, String nombre, String password, Roles rol, LocalDate fechaNacimiento) {
        this.username = username;
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDto that = (UsuarioDto) o;
        return Objects.equals(username, that.username) && Objects.equals(nombre, that.nombre) && Objects.equals(password, that.password) && rol == that.rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, nombre, password, rol);
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "dni='" + username + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}
