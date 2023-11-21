package com.example.educarparatransformar.Activity


import Entity.Estudiante
import Entity.Profesor
import Service.PostApiService
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.educarparatransformar.R
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlumnosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnos)
        supportActionBar?.title = ""

        val buscarButton:Button = findViewById<Button>(R.id.buscarButton)

        val intent: Intent = intent
        val profesor = intent.getSerializableExtra("profesor") as Profesor

        val nombresMaterias = mutableListOf<String>()

        profesor.materias.forEach { materia ->
            val nombreMateria = materia.nombre
            nombresMaterias.add(nombreMateria)
        }

        val spinner: Spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresMaterias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View?, position: Int, id: Long) {
                // Obtén el valor seleccionado
                val itemSeleccionado = parentView.getItemAtPosition(position).toString()

                // Haz algo con el valor seleccionado
                // Por ejemplo, puedes imprimirlo en el Log
                Log.d("Spinner", "Item seleccionado: $itemSeleccionado")
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Se llama cuando no hay ningún elemento seleccionado
            }
        }
        spinner.adapter = adapter

        buscarButton.setOnClickListener() {
            val nombreMateria:String = (spinner.selectedView as TextView).text.toString()
            val idMateria = profesor.materias.find { it.nombre == nombreMateria }?.id

            if (idMateria != null) {
                val urlBase = "https://api-educarparatransformar.azurewebsites.net/"
                val retrofit = Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val service = retrofit.create(PostApiService::class.java)
                lifecycleScope.launch {
                    val response = service.obtenerAlumnos(idMateria)
                    var alumnos:List<Estudiante> = response
                    val estudianteAdapter = EstudianteAdapter(this@AlumnosActivity, alumnos)
                    val listView: ListView = findViewById(R.id.listView)
                    listView.adapter = estudianteAdapter
                }
            } else {
                // Manejar el caso cuando no se encuentra la materia con el nombre especificado.
            }
        }
    }
}

class EstudianteAdapter(private val context: Context, private val alumnos: List<Estudiante>) :
    ArrayAdapter<Estudiante>(context, R.layout.item_estudiante, alumnos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.item_estudiante, parent, false)

        // Obtén los elementos de la vista
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        val dniTextView: TextView = itemView.findViewById(R.id.dniTextView)

        // Obtén el objeto MateriaEstudiante para la posición actual
        val alumno = alumnos[position]

        // Configura los valores en los elementos de la vista
        dniTextView.text = "DNI: ${alumno.dni}"
        nombreTextView.text = "Nombre: ${alumno.nombre}"

        return itemView
    }
}
