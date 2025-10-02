package com.puzzle.game.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.puzzle.game.R

class ChyHistoryAdapter(private val data: List<String>) : RecyclerView.Adapter<HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history_chy, parent, false)
        return HistoryViewHolder(view)
    }
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(data[position])
    }
    override fun getItemCount() = data.size
}

class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(text: String) {
        (itemView.findViewById<TextView>(R.id.tvHistoryScore)).text = text
    }
} 