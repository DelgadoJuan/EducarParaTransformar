package Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Horario implements Serializable {
    @SerializedName("id")
    private Long id;
    @SerializedName("dia")
    private String dia;
    @SerializedName("inicio")
    private String inicio;
    @SerializedName("fin")
    private String fin;

    public Horario(Long id, String dia, String inicio, String fin) {
        this.id = id;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horario horario = (Horario) o;
        return Objects.equals(id, horario.id) && Objects.equals(dia, horario.dia) && Objects.equals(inicio, horario.inicio) && Objects.equals(fin, horario.fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia, inicio, fin);
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", dia='" + dia + '\'' +
                ", inicio='" + inicio + '\'' +
                ", fin='" + fin + '\'' +
                '}';
    }
}
