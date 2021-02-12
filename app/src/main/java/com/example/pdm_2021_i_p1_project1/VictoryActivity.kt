package com.example.pdm_2021_i_p1_project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_victory.*

class VictoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)
        btnBackToMenuFromVictory.setOnClickListener{(onBackPressed())}
    }
}