package com.example.challenge5.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.challenge5.R
import com.example.challenge5.pilihangame.MainActivityPilihan


class TigaFragment : Fragment() {

    private lateinit var btn5: ImageView
//    private lateinit var etNama: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tiga, container, false)
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<ImageView>(R.id.next3)
        val editTxt = view.findViewById<EditText>(R.id.etNama)

//        etNama = view.findViewById(R.id.etNama)

        editTxt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.isNotEmpty() == true) {
                    button.visibility = View.VISIBLE
                } else {
                    button.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        btn5 = view.findViewById(R.id.next3)
        btn5.setOnClickListener {
            val nama = editTxt.text
            val intent = Intent(activity, MainActivityPilihan::class.java)
            intent.putExtra("Name", nama.toString())
            activity!!.startActivity(intent)
        }
    }
}
