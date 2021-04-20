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

class MainActivityPemain : AppCompatActivity(), Callback {

    private lateinit var kembali: ImageView
    private lateinit var btnPemain1: ImageView
    private lateinit var btnPemain12: ImageView
    private lateinit var btnPemain13: ImageView
    private lateinit var btnCom1: ImageView
    private lateinit var btnCom12: ImageView
    private lateinit var btnCom13: ImageView
    private lateinit var btnRefresh: ImageView
    private lateinit var imageStatus: ImageView
    private var pilihanPemain = ""
    private var pilihanPemain2 = ""
    private lateinit var txtHasil: String

    private val controller = Controller(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pemain)

        val nama = intent.getStringExtra("Name")
        val textView = findViewById<TextView>(R.id.pemain1)
        textView.setText("$nama").toString()

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

        var clicked = true

        btnPemain1.setOnClickListener {
            pilihanPemain = "Batu"
            btnPemain1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            clicked = true
            btnPemain12.isEnabled = false
            btnPemain13.isEnabled = false
            if (pilihanPemain2 > 0.toString()) {
                controller.hitung(pilihanPemain, pilihanPemain2, nama)
            }
            Toast.makeText(this, "$nama Memilih Batu", Toast.LENGTH_SHORT).show()
        }


        btnPemain12.setOnClickListener {
            pilihanPemain = "Kertas"
            btnPemain12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            clicked = true
            btnPemain1.isEnabled = false
            btnPemain13.isEnabled = false
            if (pilihanPemain2 > 0.toString()) {
                controller.hitung(pilihanPemain, pilihanPemain2, nama)
            }
            Toast.makeText(this, "$nama Memilih Kertas", Toast.LENGTH_SHORT).show()
        }


        btnPemain13.setOnClickListener {
            pilihanPemain = "Gunting"
            btnPemain13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            clicked = true
            btnPemain1.isEnabled = false
            btnPemain12.isEnabled = false
            if (pilihanPemain2 > 0.toString()) {
                controller.hitung(pilihanPemain, pilihanPemain2, nama)
            }
            Toast.makeText(this, "$nama Memilih Gunting", Toast.LENGTH_SHORT).show()
        }


        btnCom1 = findViewById(R.id.batu21)
        btnCom12 = findViewById(R.id.kertas21)
        btnCom13 = findViewById(R.id.gunting21)

        btnCom1.setOnClickListener {
            pilihanPemain2 = "Batu"
            btnCom1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            clicked = true
            btnCom12.isEnabled = false
            btnCom13.isEnabled = false
            if (pilihanPemain > 0.toString()) {
                controller.hitung(pilihanPemain, pilihanPemain2, nama)
            }
            Toast.makeText(this, "Pemain2 Memilih Batu", Toast.LENGTH_SHORT).show()

        }


        btnCom12.setOnClickListener {
            pilihanPemain2 = "Kertas"
            btnCom12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            clicked = true
            btnCom1.isEnabled = false
            btnCom13.isEnabled = false
            if (pilihanPemain > 0.toString()) {
                controller.hitung(pilihanPemain, pilihanPemain2, nama)
            }
            Toast.makeText(this, "Pemain2 Memilih Kertas", Toast.LENGTH_SHORT).show()
        }

        btnCom13.setOnClickListener {
            pilihanPemain2 = "Gunting"
            btnCom13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg1))
            clicked = true
            btnCom1.isEnabled = false
            btnCom12.isEnabled = false
            if (pilihanPemain > 0.toString()) {
                controller.hitung(pilihanPemain, pilihanPemain2, nama)
            }
            Toast.makeText(this, "Pemain2 Memilih Gunting", Toast.LENGTH_SHORT).show()
        }


        btnRefresh.setOnClickListener()
        {
            btnPemain1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnPemain12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnPemain13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnCom1.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnCom12.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            btnCom13.setBackgroundColor(ContextCompat.getColor(this, R.color.bg))
            imageStatus.setImageResource(R.drawable.vs)
            btnPemain1.isEnabled = true
            btnPemain12.isEnabled = true
            btnPemain13.isEnabled = true
            btnCom1.isEnabled = true
            btnCom12.isEnabled = true
            btnCom13.isEnabled = true

        }

    }

    override fun kirimStatus(status: String) {

        val nama = intent.getStringExtra("Name")

        txtHasil = status
        when {
            status.contains("?") -> {
                imageStatus.setImageResource(R.drawable.vs)
                Log.i("Hasil", "Pemain1 Menang")

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
                    val intent = Intent(this, MainActivityPemain::class.java)
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


            status.contains("2") -> {
                imageStatus.setImageResource(R.drawable.vs)
                Log.i("Hasil", "Pemain2 Menang")
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
                    val intent = Intent(this, MainActivityPemain::class.java)
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
            else -> {
                imageStatus.setImageResource(R.drawable.vs)
                Log.i("Hasil", "Draw")
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
                    val intent = Intent(this, MainActivityPemain::class.java)
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

    override fun kirimPemain(pemain2: String) {

    }
}




