package com.example.lab09app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskList = List(20) { index ->
            TaskItem(
                id = index + 1,
                title = "Zadanie #${index + 1}",
                category = if (index % 2 == 0) "Uczelnia" else "Dom"
            )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = TaskAdapter(taskList) { clickedTask ->
            Log.d("LAB9_LOGCAT", "Kliknięto element: ID=${clickedTask.id}, Tytuł='${clickedTask.title}'")
        }
    }
}