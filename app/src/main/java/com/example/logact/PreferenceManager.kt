package com.example.logact

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveUserProfile(name: String, lastName: String, email: String, password: String) {
        editor.putString("name", name)
        editor.putString("lastName", lastName)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }

    fun saveUserEmail(email: String) {
        editor.putString("user_email", email)
        editor.apply()
    }

    fun getUserProfile(): UserProfile {
        return UserProfile(
            sharedPreferences.getString("name", "") ?: "",
            sharedPreferences.getString("lastName", "") ?: "",
            sharedPreferences.getString("email", "") ?: "",
            sharedPreferences.getString("password", "") ?: ""
        )
    }

    fun getUserEmail(): String {
        return sharedPreferences.getString("user_email", "") ?: ""
    }

    fun getUserPassword(): String {
        return sharedPreferences.getString("password", "") ?: ""
    }

    fun clearUserProfile() {
        editor.remove("name")
        editor.remove("lastName")
        editor.remove("email")
        editor.remove("password")
        editor.apply()
    }

    data class UserProfile(
        val name: String,
        val lastName: String,
        val email: String,
        val password: String
    )
}


