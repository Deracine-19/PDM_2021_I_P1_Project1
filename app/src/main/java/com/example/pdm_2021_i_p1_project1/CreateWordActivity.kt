package com.example.pdm_2021_i_p1_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_word.*
import kotlinx.android.synthetic.main.activity_defeat.*

class WORD{
    var setword: String=""
    var setclue: String=""
}
class CreateWordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_word)

        btnSave.setOnClickListener{(load())}


    }
    fun load(){


        // Create the Intent object of this class Context() to Second_activity class
        val intent = Intent(this, PlayActivity::class.java)

        // now by putExtra method put the value in key, value pair
        // key is message_key by this key we will receive the value, and put the string
        intent.putExtra("setword", editTextTypeAWord.text.toString())
        intent.putExtra("setclue", editTextHint.text.toString())

        // start the Intent
        startActivity(intent)

    }
}











