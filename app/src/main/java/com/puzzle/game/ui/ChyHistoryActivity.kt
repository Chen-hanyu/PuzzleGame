package com.puzzle.game.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puzzle.game.R
import com.google.firebase.auth.FirebaseAuth

class ChyHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_chy)
        val recyclerView = findViewById<RecyclerView>(R.id.historyList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val scores = loadScores()
        recyclerView.adapter = ChyHistoryAdapter(scores)
    }

    private fun loadScores(): List<String> {
        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid ?: "guest"
        val prefs = getSharedPreferences("history_scores_$uid", Context.MODE_PRIVATE)
        val set = prefs.getStringSet("scores", emptySet()) ?: emptySet()
        return set.sortedBy { it }
    }
} 