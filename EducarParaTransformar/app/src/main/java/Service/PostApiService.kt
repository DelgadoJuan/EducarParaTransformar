package Service

import Entity.Estudiante
import Entity.Profesor
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApiService {
    @GET("profesores")
    suspend fun obtenerProfesores():ArrayList<Profesor>
    @GET("alumnos/{idMateria}")
    suspend fun obtenerAlumnos(@Path("idMateria") idMateria: Long):ArrayList<Estudiante>
}