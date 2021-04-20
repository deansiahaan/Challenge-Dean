package com.example.challenge5.pilihangame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.challenge5.R
import com.example.challenge5.game.MainActivity
import com.example.challenge5.game.MainActivityPemain
import com.google.android.material.snackbar.Snackbar

class MainActivityPilihan : AppCompatActivity() {

    private lateinit var pemain1: ImageView
    private lateinit var cpu1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pilihan)


        val nama = intent.getStringExtra("Name")
        val textView = findViewById<TextView>(R.id.nama4pemain)
        textView.setText("$nama vs Pemain").toString()

        val textView1 = findViewById<TextView>(R.id.nama5cpu)
        textView1.setText("$nama vs CPU").toString()

        val parentLayout: View = findViewById(android.R.id.content)
        val snackBar =
            Snackbar.make(parentLayout, "Selamat Datang $nama", Snackbar.LENGTH_INDEFINITE)

        snackBar.setAction("Tutup") {
            snackBar.dismiss()
        }

        snackBar.show()


        pemain1 = findViewById(R.id.avatar4)
        cpu1 = findViewById(R.id.avatar5)

        cpu1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Name", nama.toString())
            startActivity(intent)
        }

        pemain1.setOnClickListener {
            val intent = Intent(this, MainActivityPemain::class.java)
            intent.putExtra("Name", nama.toString())
            startActivity(intent)
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity() //  finish()
    }
}
