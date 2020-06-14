package com.example.hearthstonebuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.activity_card_details.*

const val CARD_IMG = "extra_card_img"
const val CARD_NAME = "extra_card_name"
const val CARD_DMG = "extra_card_damage"
const val CARD_INFO = "extra_card_info"

class CardDetailsActivity : AppCompatActivity() {

    private lateinit var cardImg: ImageView
    private lateinit var cardName: TextView
    private lateinit var cardDmg: TextView
    private lateinit var cardInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_details)

        cardImg = findViewById(R.id.card_img)
        cardName = findViewById(R.id.card_name)
        cardDmg = findViewById(R.id.card_attack)
        cardInfo = findViewById(R.id.card_info)

        val extras = intent.extras

        if (extras != null){
            populateDetails(extras)
        } else {
            finish()
        }
    }

    private fun populateDetails(extras: Bundle) {
        extras.getString(CARD_IMG)?.let { backdropPath ->
            Glide.with(this)
                .load(backdropPath)
                .transform(CenterCrop())
                .into(card_img)
        }
        cardName.text = extras.getString(CARD_NAME, "")
        cardDmg.text = extras.getString(CARD_DMG, "")
        cardInfo.text = extras.getString(CARD_INFO, "")
    }
}
