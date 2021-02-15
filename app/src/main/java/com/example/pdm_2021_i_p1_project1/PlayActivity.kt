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

    //private val createMatrix = Array(words.size){Array<String?>(2){null}}

    /**private fun readFile(): MutableList<String> {
        val inputStream: InputStream = File("assets.txt").inputStream()
        val wordsF = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { wordsF.add(it) } }
        return wordsF}*/

    private val lives : Int = 4
    private var fails : Int = 0
    private var correctGuesses = mutableSetOf<Char>()
    private var guesses = mutableSetOf<Char>()
    var pickedWord = pickWord()
    private val word = words[pickedWord].toLowerCase(Locale.ROOT)
    private val clue = clues[pickedWord]
    private val letters = word.toLowerCase(Locale.ROOT).toCharArray().toHashSet()
    private val txtArray = arrayOfNulls<TextView>(word.length)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        btnCheck.setOnClickListener{(checkWord())}
        createTxtViews()
        txvClue.text = clue.toUpperCase(Locale.ROOT)
        txvLives.text = "❤❤❤❤"
    }

    private fun checkWord(){
        val character = txtPlayAddLetter.text.toString().toLowerCase(Locale.ROOT)
        if (txtPlayAddLetter.text.isNotEmpty()){
            if (word.contains(txtPlayAddLetter.text.toString().toLowerCase(Locale.ROOT))) {
                correctGuesses.add(character[0])
                guesses.add(character[0])
                txvGuessed.text = guesses.toString().toUpperCase(Locale.ROOT)
                txvTest.text = letters.toString()
                showLetters()
                txtPlayAddLetter.text.clear()
                checkGameState()
            }
            else
            {
                fails++
                guesses.add(character[0])
                txvGuessed.text = guesses.toString().toUpperCase(Locale.ROOT)
                txtPlayAddLetter.text.clear()
                val hearts = txvLives.text.dropLast(1)
                txvLives.text = hearts
                when (fails) {
                    1 -> {frame1.isVisible = false
                          frame2.isVisible = true}
                    2 -> {frame2.isVisible = false
                          frame3.isVisible = true}
                    3 -> {frame3.isVisible = false
                          frame4.isVisible = true}
                    4 -> {frame4.isVisible = false
                          frame5.isVisible = true}}
                if (fails == lives)
                {
                    showDefeat()
                }
            }
        }
        else
        {
            Toast.makeText(this@PlayActivity, "Please enter a letter :)", Toast.LENGTH_LONG).show()
        }
    }

    private fun pickWord(): Int {
        //matrix()
        return (words.indices).random()
    }

    private fun showDefeat(){
        val intent = Intent(this, DefeatActivity::class.java)
        finish()
        startActivity(intent)
    }

    private fun showVictory(){
        val intent = Intent(this, VictoryActivity::class.java)
        finish()
        startActivity(intent)
    }

    private fun createTxtViews(){
        val lLayout = findViewById<View>(R.id.txtPlayGuessed) as LinearLayout
        for (i in word.indices) {
            txtArray[i] = TextView(this)
            txtArray[i]?.id = i
            txtArray[i]?.setTextColor(resources.getColor(R.color.white))
            txtArray[i]?.hint = "  _  "
            txtArray[i]?.setHintTextColor(resources.getColor(R.color.white))
            txtArray[i]?.textSize = 25F
            lLayout.addView(txtArray[i])
            txtArray[i]?.isVisible = true
        }
    }

    private fun showLetters(){
        val strrring = txtPlayAddLetter.text.toString().toLowerCase(Locale.ROOT)
        for (i in word.indices){
            if (txtPlayAddLetter.text.single().toLowerCase() == word[i]){
                txtArray[i]?.text = "  ".plus(strrring.toUpperCase(Locale.ROOT)).plus("  ")
            }
        }
    }

    private fun checkGameState(){
        if (correctGuesses == letters){
            showVictory()
            finish()
        }

    }

    /**private fun matrix(){
        for (i in words.indices){
            createMatrix[i][0] = words[i]
            createMatrix[i][1] = clues[i]
        }*/
}