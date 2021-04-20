package com.example.challenge5.game

class Controller(private val callback: Callback) {

    fun hitung(pemain1: String, pemain2: String, nama: String?)  {
        val status = when {
            pemain1 == "Batu" && pemain2 == "Gunting" || pemain1 == "Kertas" &&
                    pemain2 == "Batu" || pemain1 == "Gunting" && pemain2 == "Kertas" -> "$nama\n  MENANG!?"


            pemain1 == "Gunting" && pemain2 == "Batu" || pemain1 == "Batu" &&
                    pemain2 == "Kertas" || pemain1 == "Kertas" && pemain2 == "Gunting" -> "Pemain 2\n MENANG!"
            else -> "SERI!"


        }

        callback.kirimPemain(pemain2)
        callback.kirimStatus(status)

    }
}

