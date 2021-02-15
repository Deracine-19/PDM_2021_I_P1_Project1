package com.example.pdm_2021_i_p1_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_defeat.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPlay.setOnClickListener{(showPlay())}
        btnCreateWord.setOnClickListener{(showCreateWord())}
    }

    private fun showPlay() {
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showCreateWord() {
        val intent = Intent(this, CreateWordActivity::class.java)
        startActivity(intent)
        finish()
    }
}