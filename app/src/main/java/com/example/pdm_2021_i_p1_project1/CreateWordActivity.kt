package com.example.pdm_2021_i_p1_project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_word.*

class CreateWordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_word)

        var word = ArrayList<String>()
        for (elements in editTextTypeAWord.text) {
            word.add(elements.toString())
            var counter=0
            counter+1
        }

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

        btnSave.setOnClickListener{(save())}
    }


    private fun save() {
        var matrizcreada = Array(5) { Array<String?>(2) { null } }
        for (i in (0 until 5)) {
            matrizcreada[i][0] = editTextTypeAWord.text.toString()
            matrizcreada[i][1] = editTextHint.text.toString()
        }
    }

}











