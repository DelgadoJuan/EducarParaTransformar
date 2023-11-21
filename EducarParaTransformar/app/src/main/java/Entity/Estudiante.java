package Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Estudiante implements Serializable {
    @SerializedName("id")
    private Long id;
    @SerializedName("username")
    private String dni;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String contraseña;
    @SerializedName("fechaCreacion")
    private String fechaCreacion;
    @SerializedName("fechaNacimiento")
    private String fechaNacimiento;
    @SerializedName("rol")
    private String rol;
    @SerializedName("curso")
    private Curso curso;

    public Estudiante(Long id, String dni, String nombre, String email, String contraseña, String fechaCreacion, String fechaNacimiento, String rol, Curso curso) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.fechaCreacion = fechaCreacion;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", rol='" + rol + '\'' +
                ", curso=" + curso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(id, that.id) && Objects.equals(dni, that.dni) && Objects.equals(nombre, that.nombre) && Objects.equals(email, that.email) && Objects.equals(contraseña, that.contraseña) && Objects.equals(fechaCreacion, that.fechaCreacion) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(rol, that.rol) && Objects.equals(curso, that.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, email, contraseña, fechaCreacion, fechaNacimiento, rol, curso);
    }
}
