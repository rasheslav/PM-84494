package com.example.lab06app

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Открытие браузера
        findViewById<Button>(R.id.btnBrowser).setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.merito.pl/wroclaw/"))
            safeStartActivity(webIntent, "Brak przeglądarki internetowej")
        }

        // 2. Подготовка E-mail
        findViewById<Button>(R.id.btnEmail).setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("wrx78447@student.merito.pl"))
                putExtra(Intent.EXTRA_SUBJECT, "Pytanie z Laboratorium 06")
            }
            safeStartActivity(emailIntent, "Brak aplikacji pocztowej")
        }

        // 3. Открытие карты (координаты корпуса G WSB Merito Wrocław)
        findViewById<Button>(R.id.btnMap).setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:51.1147,16.9936?q=Uniwersytet+WSB+Merito+Wrocław+Budynek+G"))
            safeStartActivity(mapIntent, "Brak aplikacji z mapami")
        }
    }

    private fun safeStartActivity(intent: Intent, errorMessage: String) {
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}