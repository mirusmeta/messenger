package com.example.testa

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class read : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        var back:TextView = findViewById(R.id.back)
        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        var textmain:TextView = findViewById(R.id.textmain)
        var textdesc:TextView = findViewById(R.id.textdesc)
        val id = intent.getStringExtra("id").toString()
        var db = Firebase.firestore
        db.collection("reports").document(id).get().addOnSuccessListener {
            textmain.text = it.getString("name").toString()
            textdesc.text = it.getString("desctext").toString()
        }.addOnFailureListener {
            Toast.makeText(this, "Не удалось получить данные!", Toast.LENGTH_LONG).show()
        }
    }
}