package com.example.challenge5.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.challenge5.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val dataFragment = mutableListOf(SatuFragment(), DuaFragment(), TigaFragment())

        val adapter = SecondAdapter(this)
        adapter.setData(dataFragment)
        val viewPager = findViewById<ViewPager2>(R.id.viewpager2)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        viewPager.adapter = adapter
        dotsIndicator.setViewPager2(viewPager)


    }
}