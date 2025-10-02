package com.puzzle.game.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_levels")
data class ChyGameLevel(
    @PrimaryKey val id: Int,
    val name: String,
    val gridSize: Int,
    val imageUrl: String,
    val bestTime: Long = 0,
    val isUnlocked: Boolean = false
) 