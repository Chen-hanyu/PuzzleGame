package com.puzzle.game.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.puzzle.game.R
import com.puzzle.game.model.ChyRankItem

class ChyRankAdapter(private val data: List<ChyRankItem>) : RecyclerView.Adapter<ChyRankAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvRank: TextView = view.findViewById(R.id.tvRank)
        val tvUsername: TextView = view.findViewById(R.id.tvUsername)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
        val tvMoves: TextView = view.findViewById(R.id.tvMoves)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rank_chy, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.tvRank.text = (position + 1).toString()
        holder.tvUsername.text = item.username
        holder.tvTime.text = "${item.time}秒"
        holder.tvMoves.text = "${item.moves}步"
        val context: Context = holder.itemView.context
        val color = when (position) {
            0 -> ContextCompat.getColor(context, R.color.rank_gold)
            1 -> ContextCompat.getColor(context, R.color.rank_silver)
            2 -> ContextCompat.getColor(context, R.color.rank_bronze)
            else -> ContextCompat.getColor(context, android.R.color.black)
        }
        holder.tvRank.setTextColor(color)
    }
}