package com.example.pdm_2021_i_p1_project1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_play.*
import java.util.*
import java.io.File

import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_create_word.*


class PlayActivity : AppCompatActivity() {
    //Variable Declarations
    private val words = arrayOf(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July")

    private val lives = 4
    private var correctGuesses = mutableSetOf<Char>()
    private var fails = 0
    private val word = pickWord().toLowerCase(Locale.ROOT)
    private val letters = word.toLowerCase(Locale.ROOT).toCharArray().toHashSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        btnCheck.setOnClickListener{(checkWord())}


        /**
        // val str=editTextTypeAWord.text.toString()
        // val chars:CharArray=toCharacterArray(str)*


        val lLayout = findViewById<View>(R.id.LinearLayoutContainerofTxv) as LinearLayout

        for (i in 0..4) {
            val tv = TextView(this)
            tv.text = "A $i"
            tv.id = i + 5
            // tv.isVisible=false
            tv.setTextColor(getResources().getColor(R.color.white))

            lLayout.addView(tv) */
    }

    /**
    fun toCharacterArray(str:String): CharArray{
        return str.toCharArray()
    } */

    private fun checkWord(){
        if (txtPlayAddLetter.text.isNotEmpty()){
            if (word.contains(txtPlayAddLetter.text.toString().toLowerCase(Locale.ROOT))) {
                val character = txtPlayAddLetter.text.toString().toLowerCase(Locale.ROOT)
                correctGuesses.add(character[0])
                txvTest.text = correctGuesses.toString()
                txvTest4.text = letters.toString()
                txtPlayAddLetter.text.clear()
                checkGameState()
            }
            else
            {
                fails++
                txvTest2.text = fails.toString()
                if (fails == lives){
                    showDefeat()
                }
            }
        }
        else
        {
            Toast.makeText(this@PlayActivity, "Please enter a letter :)", Toast.LENGTH_LONG).show()
        }
    }

    private fun pickWord(): String {
        return words.random()
    }

    private fun showDefeat(){
        val intent = Intent(this, DefeatActivity::class.java)
        startActivity(intent)
    }

    private fun showVictory(){
        val intent = Intent(this, VictoryActivity::class.java)
        startActivity(intent)
    }

    private fun checkGameState(){
        if (correctGuesses == letters){
            showVictory()
        }
    }
}