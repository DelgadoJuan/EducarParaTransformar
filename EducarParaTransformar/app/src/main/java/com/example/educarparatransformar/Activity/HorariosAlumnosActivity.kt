package com.example.educarparatransformar.Activity
import Entity.Materia
import Entity.Profesor
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.educarparatransformar.R

class HorariosAlumnosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horariosalumnos)
        supportActionBar?.title = ""

        val intent: Intent = intent
        if (intent != null && intent.hasExtra("profesor")) {
            val profesor = intent.getSerializableExtra("profesor") as Profesor
            val materiaAdapter = MateriaAdapter(this, profesor.materias)

            val listView: ListView = findViewById(R.id.listView)
            listView.adapter = materiaAdapter
        }

    }
}

class MateriaAdapter(context: Context, materias: List<Materia>) :
    ArrayAdapter<Materia>(context, 0, materias) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.item_materia, parent, false)
        }

        val materia = getItem(position)

        val nombreTextView: TextView = listItemView!!.findViewById(R.id.nombreTextView)
        val horariosTextView: TextView = listItemView.findViewById(R.id.horariosTextView)

        materia?.let {
            nombreTextView.text = it.nombre
            val horariosString = it.horarios.joinToString(", ") { horario ->
                "${horario.dia}: ${horario.inicio}-${horario.fin}"
            }
            horariosTextView.text = horariosString
        }

        return listItemView
    }
}