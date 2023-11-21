package com.example.educarparatransformar.Activity

import Entity.Profesor
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.educarparatransformar.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.title = ""

        val intent:Intent = intent

        val listaAlumnosButton: Button = findViewById<AppCompatButton>(R.id.alumnosButton)
        val horariosButton: Button = findViewById<AppCompatButton>(R.id.horariosButton)

        listaAlumnosButton.setOnClickListener() {
            if (intent != null && intent.hasExtra("profesor")) {
                val profesor:Profesor = intent.getSerializableExtra("profesor") as Profesor
                val intent = Intent(this@DashboardActivity, AlumnosActivity::class.java)
                intent.putExtra("profesor", profesor)
                startActivity(intent)
            }
        }
        horariosButton.setOnClickListener() {
            if (intent != null && intent.hasExtra("profesor")) {
                val profesor:Profesor = intent.getSerializableExtra("profesor") as Profesor
                val intent = Intent(this@DashboardActivity, HorariosAlumnosActivity::class.java)
                intent.putExtra("profesor", profesor)
                startActivity(intent)
            }
        }
    }
}