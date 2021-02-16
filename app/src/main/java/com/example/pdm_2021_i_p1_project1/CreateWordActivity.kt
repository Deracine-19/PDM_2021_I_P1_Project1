package com.example.pdm_2021_i_p1_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_word.*

class CreateWordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_word)

        var matrizcreada=Array(5){Array<String?>(2){null} }
        for (i in (0 until 5)){
            matrizcreada[i][0]=editTextTypeAWord.text.toString()
            matrizcreada[i][1]=editTextHint.text.toString()
        }

        var palabra=CharArray(editTextTypeAWord.length())
        for (j in editTextTypeAWord.text){
            for(i in editTextTypeAWord.text) {
                palabra.set(0,i.toChar())
            }
        }

        val str=editTextTypeAWord.text.toString()
        val chars:CharArray=toCharacterArray(str)

        btnSave.setOnClickListener{(showPlay())}
    }

    private fun save() {
        var matrizcreada = Array(5) { Array<String?>(2) { null } }
        for (i in (0 until 5)) {
            matrizcreada[i][0] = editTextTypeAWord.text.toString()
            matrizcreada[i][1] = editTextHint.text.toString()
        }
    }

    private fun showPlay() {
        val intent = Intent(this, PlayActivity::class.java)
        finish()
        startActivity(intent)
    }
    private fun toCharacterArray(str:String): CharArray{
        return str.toCharArray()
    }


}











