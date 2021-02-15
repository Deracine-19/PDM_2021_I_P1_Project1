package com.example.pdm_2021_i_p1_project1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_play.*
import java.util.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_create_word.*
import java.io.InputStream
import java.io.File


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

    private val clues = arrayOf(
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio")

    private val matrizCreada = Array(words.size){Array<String?>(2){null} }

 /**   fun readFile(): MutableList<String> {
        val inputStream: InputStream = File("main\\assets\\words.txt").inputStream()
        val words = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { words.add(it) } }
        return words
    }*/

    private val lives = 3
    private var correctGuesses = mutableSetOf<Char>()
    private var fails = 0
    private val word = pickWord().toLowerCase(Locale.ROOT)
    private val letters = word.toLowerCase(Locale.ROOT).toCharArray().toHashSet()
    private val txtArray = arrayOfNulls<TextView>(word.length)
    private val list = word.toCharArray().toList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        btnCheck.setOnClickListener{(checkWord())}
        createTxtViews()
    }

    private fun checkWord(){
        if (txtPlayAddLetter.text.isNotEmpty()){
            if (word.contains(txtPlayAddLetter.text.toString().toLowerCase(Locale.ROOT))) {
                val character = txtPlayAddLetter.text.toString().toLowerCase(Locale.ROOT)
                correctGuesses.add(character[0])
                txvTest.text = correctGuesses.toString()
                txvTest4.text = letters.toString()
                fuck()
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

    private fun createTxtViews(){
        val lLayout = findViewById<View>(R.id.txtPlayGuessed) as LinearLayout
        for (i in word.indices) {
            txtArray[i] = TextView(this)
            txtArray[i]?.id = i
            txtArray[i]?.setTextColor(resources.getColor(R.color.white))
            txtArray[i]?.setHint(" _ ")
            txtArray[i]?.setHintTextColor(resources.getColor(R.color.white))
            lLayout.addView(txtArray[i])
            txtArray[i]?.isVisible = true
            txvTest5.text = lLayout.childCount.toString()
        }
    }

    private fun fuck(){
        var strrring = txtPlayAddLetter.text
        for (i in word.indices){
            if (txtPlayAddLetter.text.single() == list[i]){
                txtArray[i]?.text = strrring.toString().toUpperCase(Locale.ROOT)
            }
        }
    }

    private fun checkGameState(){
        if (correctGuesses == letters){
            showVictory()
        }
    }

    private fun matrix(){
        for (i in words.indices){
            matrizCreada[i][0] = words[i]
            matrizCreada[i][1] = clues[i]
        }
    }
}