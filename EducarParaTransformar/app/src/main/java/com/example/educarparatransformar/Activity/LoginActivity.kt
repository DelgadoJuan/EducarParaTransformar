package com.example.educarparatransformar.Activity

import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.educarparatransformar.R
import org.conscrypt.Conscrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.security.Security
import java.sql.Connection
import java.sql.DriverManager


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val ingresarBtn : Button= findViewById<AppCompatButton>(R.id.loginButton)
        val passwordEncoder = BCryptPasswordEncoder()

        ingresarBtn.setOnClickListener() {
            // Inicia la lógica de la base de datos en un hilo separado
            // Utiliza un CoroutineScope que esté vinculado al ciclo de vida de la actividad
            /*lifecycleScope.launch {
                //val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
                //StrictMode.setThreadPolicy(policy)
                // Ejecuta la lógica de la base de datos en el contexto de Dispatchers.IO
                withContext(Dispatchers.IO) {
                    try {
                        // Ejecuta una consulta
                        val statement: Statement? = conexionBD()?.createStatement()
                        val resultSet: ResultSet = statement!!.executeQuery("SELECT * FROM usuario WHERE rol = 1")

                        var existe:Boolean = false
                        val dniEditText: EditText = findViewById(R.id.dniEditText)
                        val passwordEditText: EditText = findViewById(R.id.passwordEditText)

                        // Procesa los resultados
                        while (resultSet.next()) {
                            val dni = resultSet.getString("username")
                            val password = resultSet.getString("password")
                            if (dniEditText.text.toString() == dni && passwordEncoder.matches(passwordEditText.text.toString(), password)) {
                                existe = true
                                val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                                startActivity(intent)
                            }
                        }

                        if (!existe) {

                        }

                        // Cierra la conexión y otros recursos
                        resultSet.close()
                        statement.close()

                    } catch (e: Exception) {
                        // Maneja las excepciones adecuadamente
                        e.printStackTrace()
                    }
                }
            }*/
        }
    }

    fun conexionBD(): Connection? {
        var cnn: Connection? = null
        try {
            val policy = StrictMode.ThreadPolicy.Builder().build()
            StrictMode.setThreadPolicy(policy)
            val conscrypt = Conscrypt.newProviderBuilder().provideTrustManager(false).build()
            Security.insertProviderAt(conscrypt, 1)
            DriverManager.registerDriver(com.microsoft.sqlserver.jdbc.SQLServerDriver())
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
            val connectionUrl = "jdbc:sqlserver://34.176.20.231:1433;databaseName=educarparatransformar-db;TrustServerCertificate=True;user=sqlserver;password=disca123"
            cnn = DriverManager.getConnection(connectionUrl)
            runOnUiThread {
                Toast.makeText(applicationContext, "Conexión exitosa", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Log.e("LoginActivity", "Error al conectar", e)
            runOnUiThread {
                Toast.makeText(applicationContext, "Error del sistema", Toast.LENGTH_SHORT).show()
            }
        }
        return cnn
    }

}