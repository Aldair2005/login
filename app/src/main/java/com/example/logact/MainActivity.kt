package com.example.logact

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var preferenceManager: PreferenceManager
    private lateinit var textViewLogin: TextView
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonDirectToProfile: Button
    private var loginAttempts = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewLogin = findViewById(R.id.textViewLogin)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonDirectToProfile = findViewById(R.id.buttonDirectToProfile)

        preferenceManager = PreferenceManager(this)

        buttonLogin.setOnClickListener {
            val enteredEmail = editTextEmail.text.toString()
            val enteredPassword = editTextPassword.text.toString()

            // Obtener el correo electrónico y la contraseña registrados
            val registeredEmail = preferenceManager.getUserEmail()
            val registeredPassword = preferenceManager.getUserPassword()

            if (enteredEmail == registeredEmail && enteredPassword == registeredPassword) {
                // Login successful
                textViewLogin.text = "Login exitoso"

                // Después del inicio de sesión exitoso, inicia ProfileImageActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                // Login unsuccessful
                loginAttempts--

                if (loginAttempts > 0) {
                    textViewLogin.text = "error. $loginAttempts attempts left."
                } else {
                    textViewLogin.text = " No mas intentos."

                    // Deshabilitar el botón de inicio de sesión y los campos de entrada
                    buttonLogin.isEnabled = false
                    editTextEmail.isEnabled = false
                    editTextPassword.isEnabled = false
                }
            }
        }

        buttonDirectToProfile.setOnClickListener {
            // Acción para ir directamente a ProfileActivity
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}








