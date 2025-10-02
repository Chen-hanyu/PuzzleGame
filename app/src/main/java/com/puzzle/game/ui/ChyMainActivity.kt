package com.puzzle.game.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.puzzle.game.R

class ChyMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_chy)

        findViewById<MaterialCardView>(R.id.cardStartGame).setOnClickListener {
            startActivity(Intent(this, ChyGameSettingActivity::class.java))
        }

        findViewById<MaterialCardView>(R.id.cardHistory).setOnClickListener {
            startActivity(Intent(this, ChyHistoryActivity::class.java))
        }

        findViewById<MaterialCardView>(R.id.cardUserInfo).setOnClickListener {
            startActivity(Intent(this, ChyUserInfoActivity::class.java))
        }

        findViewById<MaterialCardView>(R.id.cardRank).setOnClickListener {
            startActivity(Intent(this, ChyRankActivity::class.java))
        }
    }
}