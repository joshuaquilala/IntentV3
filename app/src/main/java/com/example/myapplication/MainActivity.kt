package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val usernameText = findViewById<EditText>(R.id.txtUsername)
            val username = usernameText.text.toString();

            val passwordText = findViewById<EditText>(R.id.txtPassword)
            val password = passwordText.text.toString();

            if (username.equals("Joshua") && password.equals("joshuajoshua")) {
                LoginPage()

            } else {
                Toast.makeText(this, "Incorrect username or password.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun LoginPage() {
        val intent = Intent(this, Application::class.java)
        startActivity(intent)
        Toast.makeText(this, "You are logged in", Toast.LENGTH_SHORT).show()
    }
}