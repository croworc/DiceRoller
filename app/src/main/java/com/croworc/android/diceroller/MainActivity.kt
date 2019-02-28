package com.croworc.android.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnRoll : Button = findViewById(R.id.roll_button)
        btnRoll.text = "Let's roll!"
        btnRoll.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = (1..6).shuffled().first().toString()
    }
}
