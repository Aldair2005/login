package com.example.logact

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textViewEmail: TextView = findViewById(R.id.textViewEmail)
        val imageView: ImageView = findViewById(R.id.imageView)

        // Obtener el correo electrónico de SharedPreferences
        val preferenceManager = PreferenceManager(this)
        val userEmail = preferenceManager.getUserEmail()

        // Configurar el texto del TextView con el correo electrónico
        textViewEmail.text = userEmail
    }
}

