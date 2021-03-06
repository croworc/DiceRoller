package com.croworc.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

private const val KEY_DICE_RESOURCE_ID = "dice_resource_id_key"

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

        savedInstanceState?.run {
            val drawableResource: Int = getInt(KEY_DICE_RESOURCE_ID)
            if (drawableResource != 0) {
                diceImage.setImageResource(drawableResource)
                diceImage.tag = drawableResource
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (diceImage.tag != null) {
            outState.putInt(KEY_DICE_RESOURCE_ID, diceImage.tag as Int)
        }
    }

    private fun rollDice() {
        val drawableResource = when ((1..6).random()) {
            1    -> R.drawable.dice_1
            2    -> R.drawable.dice_2
            3    -> R.drawable.dice_3
            4    -> R.drawable.dice_4
            5    -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.tag = drawableResource
    }
}
