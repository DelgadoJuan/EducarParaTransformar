package Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Curso implements Serializable {
    @SerializedName("id")
    private Long id;
    @SerializedName("año")
    private String nombre;
    @SerializedName("nivel")
    private String nivel;
    @SerializedName("aula")
    private Aula aula;
}
