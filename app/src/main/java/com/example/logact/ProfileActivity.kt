package com.example.logact

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextLastName: EditText = findViewById(R.id.editTextLastName)
        val editTextProfileEmail: EditText = findViewById(R.id.editTextProfileEmail)
        val editTextProfilePassword: EditText = findViewById(R.id.editTextProfilePassword)
        val editTextRepeatPassword: EditText = findViewById(R.id.editTextRepeatPassword)
        val buttonSaveProfile: Button = findViewById(R.id.buttonSaveProfile)

        preferenceManager = PreferenceManager(this)

        // Limpiar los datos del perfil cada vez que se ingresa a ProfileActivity
        preferenceManager.clearUserProfile()

        // Obtener el perfil del usuario almacenado (ahora estará vacío)
        val userProfile = preferenceManager.getUserProfile()

        // Configurar los EditText con los datos almacenados (que ahora estarán vacíos)
        editTextName.setText(userProfile.name)
        editTextLastName.setText(userProfile.lastName)
        editTextProfileEmail.setText(userProfile.email)
        editTextProfilePassword.setText(userProfile.password)

        buttonSaveProfile.setOnClickListener {
            val name = editTextName.text.toString()
            val lastName = editTextLastName.text.toString()
            val email = editTextProfileEmail.text.toString()
            val password = editTextProfilePassword.text.toString()
            val repeatPassword = editTextRepeatPassword.text.toString()

            // Verificar si la contraseña se repitió correctamente
            if (password == repeatPassword) {
                // Guardar los datos del perfil
                preferenceManager.saveUserProfile(name, lastName, email, password)

                // Guardar el correo electrónico para iniciar sesión
                preferenceManager.saveUserEmail(email)

                // Mostrar un mensaje de "Información guardada" usando Toast
                showToast("Información guardada")
            } else {
                // Mostrar un mensaje si las contraseñas no coinciden
                showToast("Las contraseñas no coinciden. Por favor, inténtalo de nuevo.")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}











