package com.puzzle.game.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.puzzle.game.R
import com.puzzle.game.model.ChyRankItem

class ChyRankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank_chy)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerRank)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val db = FirebaseFirestore.getInstance()
        db.collection("users")
            .whereGreaterThan("rankTime", 0)
            .orderBy("rankTime")
            .limit(20)
            .get()
            .addOnSuccessListener { result ->
                val data = result.documents.map { doc ->
                    ChyRankItem(
                        username = doc.getString("username") ?: "匿名",
                        time = doc.getLong("rankTime")?.toInt() ?: 0,
                        moves = doc.getLong("rankMoves")?.toInt() ?: 0
                    )
                }
                recyclerView.adapter = ChyRankAdapter(data)
            }
            .addOnFailureListener {
                recyclerView.adapter = ChyRankAdapter(listOf(ChyRankItem("获取失败", 0, 0)))
            }
    }
}