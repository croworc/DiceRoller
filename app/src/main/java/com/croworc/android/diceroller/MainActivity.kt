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

        // Restore the saved state, if any
        savedInstanceState?.run {
            // If the user has pushed the [ROLL] button already, the image resource ID
            // of the ImageView's drawable has been saved in the view's `tag` property.
            // In onSaveInstanceState the ID stored in this tag gets put into the bundle.
            // Here, we first check whether there's such an ID stored in the bundle, because
            // if the device was rotated *before* the dice was rolled, then there's no ID
            // stored in the tag property and thus also no ID in the bundle.
            val drawableResource = getInt(KEY_DICE_RESOURCE_ID)
            if (drawableResource != 0) {
                diceImage.setImageResource(drawableResource)
                diceImage.tag = drawableResource
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // If the dice has been rolled already, then we've put the drawable's resource ID
        // into the ImageView's `tag` property.
        // Here, we save this resource ID from the tag property into the bundle.
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
        // We'll store away the drawable resource ID into the view's `tag` property,
        // so that we can save it in onSaveInstanceState, later and restore it in onCreate.
        diceImage.tag = drawableResource
    }
}
