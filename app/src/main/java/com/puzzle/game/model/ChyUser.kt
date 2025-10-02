package com.puzzle.game.model

data class ChyUser(
    val uid: String,
    val username: String,
    val email: String,
    val totalScore: Int = 0,
    val completedLevels: List<Int> = listOf(),
    val currentLevel: Int = 1
)