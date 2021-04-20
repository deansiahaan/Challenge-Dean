package com.example.challenge5.game

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.challenge5.R
import com.example.challenge5.pilihangame.MainActivityPilihan


class MainActivity : AppCompatActivity(), Callback {

    private lateinit var kembali: ImageView
    private lateinit var btnPemain1: ImageView
    private lateinit var btnPemain12: ImageView
    private lateinit var btnPemain13: ImageView
    private lateinit var btnCom1: ImageView
    private lateinit var btnCom12: ImageView
    private lateinit var btnCom13: ImageView
    private lateinit var btnRefresh: ImageView
    private lateinit var imageStatus: ImageView
    private lateinit var txtHasil: String

    private val controller = Controller(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nama = intent.getStringExtra("Name")
        val textView = findViewById<TextView>(R.id.pemain1)
        textView.setText("$nama").toString()

        var clicked = true

        kembali = findViewById(R.id.kembali)

        kembali.setOnClickListener {
            val intent = Intent(this, MainActivityPilihan::class.java)
            intent.putExtra("Name", nama.toString())
            startActivity(intent)
        }

        btnPemain1 = findViewById(R.id.batu1)
        btnPemain12 = findViewById(R.id.kertas1)
        btnPemain13 = findViewById(R.id.gunting1)
        imageStatus = findViewById(R.id.vs)
        btnRefresh = findViewById(R.id.refresh)


        btnRefresh.setOnClickListener()
        {
            btnPemain1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnPemain12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnPemain13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnCom1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnCom12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnCom13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            imageStatus.setImageResource(R.drawable.vs)
            clicked = true

        }

        btnCom1 = findViewById(R.id.batu2)
        btnCom12 = findViewById(R.id.kertas2)
        btnCom13 = findViewById(R.id.gunting2)

        val cpu = mutableListOf("Batu", "Kertas", "Gunting")


        btnPemain1.setOnClickListener {
            if (clicked) {
                val plhCom = cpu.random()
                controller.hitung("Batu", plhCom, nama)
                btnPemain1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
                clicked = false
                Toast.makeText(this, "Com Memilih $plhCom", Toast.LENGTH_SHORT).show()
                val view = LayoutInflater.from(this).inflate(R.layout.dialog1, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()

                val textView4 = dialog.findViewById<TextView>(R.id.hasilpermainan)
                textView4?.setText(txtHasil).toString()

                val btnMain = view.findViewById<Button>(R.id.buttonmain)
                btnMain.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("Name", nama.toString())
                    startActivity(intent)
                }

                val btnKembali = view.findViewById<Button>(R.id.buttonkembali)
                btnKembali.setOnClickListener {
                    val intent = Intent(this, MainActivityPilihan::class.java)
                    intent.putExtra("Name", nama.toString())
                    startActivity(intent)
                }
            }
        }

        btnPemain12.setOnClickListener {
            if (clicked) {
                val plhCom = cpu.random()
                controller.hitung("Kertas", plhCom, nama)
                btnPemain12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
                clicked = false
                Toast.makeText(this, "Com Memilih $plhCom", Toast.LENGTH_SHORT).show()
                val view = LayoutInflater.from(this).inflate(R.layout.dialog1, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()

                val textView4 = dialog.findViewById<TextView>(R.id.hasilpermainan)
                textView4?.setText(txtHasil).toString()

                val btnMain = view.findViewById<Button>(R.id.buttonmain)
                btnMain.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("Name", nama.toString())
                    startActivity(intent)
                }

                val btnKembali = view.findViewById<Button>(R.id.buttonkembali)
                btnKembali.setOnClickListener {
                    val intent = Intent(this, MainActivityPilihan::class.java)
                    intent.putExtra("Name", nama.toString())
                    startActivity(intent)
                }
            }
        }

        btnPemain13.setOnClickListener {
            if (clicked) {
                val plhCom = cpu.random()
                controller.hitung("Gunting", plhCom, nama)
                btnPemain13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
                clicked = false
                Toast.makeText(this, "Com Memilih $plhCom", Toast.LENGTH_SHORT).show()
                val view = LayoutInflater.from(this).inflate(R.layout.dialog1, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()

                val textView4 = dialog.findViewById<TextView>(R.id.hasilpermainan)
                textView4?.setText(txtHasil).toString()

                val btnMain = view.findViewById<Button>(R.id.buttonmain)
                btnMain.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("Name", nama.toString())
                    startActivity(intent)
                }

                val btnKembali = view.findViewById<Button>(R.id.buttonkembali)
                btnKembali.setOnClickListener {
                    val intent = Intent(this, MainActivityPilihan::class.java)
                    intent.putExtra("Name", nama.toString())
                    startActivity(intent)
                }
            }
        }
    }


    override fun kirimStatus(status: String) {
        txtHasil = status
        when {
            status.contains("1") -> {
                imageStatus.setImageResource(R.drawable.vs)
                Log.i("Hasil", "Pemain1 Menang")
            }
            status.contains("2") -> {
                imageStatus.setImageResource(R.drawable.vs)
                Log.i("Hasil", "Pemain2 Menang")
            }
            else -> {
                imageStatus.setImageResource(R.drawable.vs)
                Log.i("Hasil", "Draw")


            }
        }


    }

    override fun kirimPemain(pemain2: String) {
        when (pemain2) {
            "Batu" -> {
                btnCom1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            }
            "Kertas" -> {
                btnCom12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            }
            else -> {
                btnCom13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            }
        }

    }
}





