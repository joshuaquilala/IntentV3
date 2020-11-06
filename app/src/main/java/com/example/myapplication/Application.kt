package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import android.widget.Button
import android.widget.Toast

class Application : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)

        findViewById<Button>(R.id.btnFilestorage).setOnClickListener { Image() }
        findViewById<Button>(R.id.btnMessage).setOnClickListener { Messages() }
        findViewById<Button>(R.id.btnWifi).setOnClickListener { Wifi() }
        findViewById<Button>(R.id.btnTimer).setOnClickListener { Timer() }
        findViewById<Button>(R.id.btnSettings).setOnClickListener { Settings() }
    }

    val REQUEST_IMAGE_GET = 1
    fun Image() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
        }

            startActivityForResult(intent, REQUEST_IMAGE_GET)

    }

    private fun Wifi() {
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun Messages() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
        startActivity(intent)
    }
    //The next two functions will fails intentionally
    fun Timer() {
        val intent = Intent(AlarmClock.ACTION_SHOW_TIMERS)
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Cannot open TIMER.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun Settings() {
        val intent = Intent(Settings.ACTION_SETTINGS)
        intent.addCategory(Intent.ACTION_ALL_APPS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Cannot open SETTINGS.", Toast.LENGTH_SHORT).show()
        }
    }

}