package com.example.educarparatransformar.Activity

import Service.PostApiService
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.lifecycleScope
import com.example.educarparatransformar.R
import kotlinx.coroutines.launch
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.title = ""

        val ingresarBtn : Button= findViewById<AppCompatButton>(R.id.loginButton)
        val passwordEncoder = BCryptPasswordEncoder()

        ingresarBtn.setOnClickListener() {
            // Inicia la lógica de la base de datos en un hilo separado
            // Utiliza un CoroutineScope que esté vinculado al ciclo de vida de la actividad
            val urlBase = ("https://api-educarparatransformar.azurewebsites.net/")
            val retrofit = Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(PostApiService::class.java)
            lifecycleScope.launch {
                val dniEditText:EditText = findViewById(R.id.dniEditText)
                val contraseñaEditText:EditText = findViewById(R.id.passwordEditText)
                val response = service.obtenerProfesores()
                var existe:Boolean = false
                response.forEach { profesor ->
                    if (dniEditText.text.toString() == profesor.dni && passwordEncoder.matches(contraseñaEditText.text.toString(), profesor.contraseña)) {
                        val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                        existe = true
                        intent.putExtra("profesor", profesor)
                        startActivity(intent)
                    }
                }
                if (!existe) {
                    println("error")
                }
            }
        }
    }
}