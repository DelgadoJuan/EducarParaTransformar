package Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Profesor implements Serializable {

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
    @SerializedName("materias")
    private List<Materia> materias;

    public Profesor(Long id, String dni, String contraseña, String nombre, String email, String fechaNacimiento, String fechaCreacion, String rol, List<Materia> materias) {
        this.id = id;
        this.dni = dni;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
        this.rol = rol;
        this.materias = materias;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", rol='" + rol + '\'' +
                ", materias=" + materias +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(id, profesor.id) && Objects.equals(dni, profesor.dni) && Objects.equals(nombre, profesor.nombre) && Objects.equals(email, profesor.email) && Objects.equals(contraseña, profesor.contraseña) && Objects.equals(fechaCreacion, profesor.fechaCreacion) && Objects.equals(fechaNacimiento, profesor.fechaNacimiento) && Objects.equals(rol, profesor.rol) && Objects.equals(materias, profesor.materias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, email, contraseña, fechaCreacion, fechaNacimiento, rol, materias);
    }
}
