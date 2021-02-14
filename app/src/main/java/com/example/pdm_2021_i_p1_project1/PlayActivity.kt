package com.example.pdm_2021_i_p1_project1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_play.*
import kotlinx.android.synthetic.main.activity_create_word.*

class PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        // val str=editTextTypeAWord.text.toString()
        // val chars:CharArray=toCharacterArray(str)*


        val lLayout = findViewById<View>(R.id.LinearLayoutContainerofTxv) as LinearLayout

        for (i in 0..4) {
            val tv = TextView(this)
            tv.text = "A $i"
            tv.id = i + 5
           // tv.isVisible=false
            tv.setTextColor(getResources().getColor(R.color.white))

            lLayout.addView(tv)
        }














    }
    fun toCharacterArray(str:String): CharArray{
        return str.toCharArray()
    }

}