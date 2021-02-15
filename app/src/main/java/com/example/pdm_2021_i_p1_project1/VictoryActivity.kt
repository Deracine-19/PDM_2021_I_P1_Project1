package com.example.pdm_2021_i_p1_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_victory.*

class VictoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)
        btnBackToMenuFromVictory.setOnClickListener{(backToMainMenu())}
        btnPlayAgain.setOnClickListener{(playAgain())}
    }

    private fun backToMainMenu(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun playAgain(){
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)
    }
}