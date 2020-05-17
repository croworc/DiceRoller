package com.croworc.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll : Button = findViewById(R.id.roll_button)
        btnRoll.text = getString(R.string.roll)
        btnRoll.setOnClickListener {
            rollDice()
        }

        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val drawableResource = when ((1..6).shuffled().first()) {
            1    -> R.drawable.dice_1
            2    -> R.drawable.dice_2
            3    -> R.drawable.dice_3
            4    -> R.drawable.dice_4
            5    -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}
