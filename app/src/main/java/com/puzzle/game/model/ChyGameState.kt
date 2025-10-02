package com.puzzle.game.model

data class ChyGameState(
    val pieceOrder: List<Int>,
    val gridSize: Int,
    val selectedIndex: Int?,
    val moves: Int,
    val isCompleted: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChyGameState

        if (pieceOrder != other.pieceOrder) return false
        if (gridSize != other.gridSize) return false
        if (selectedIndex != other.selectedIndex) return false
        if (moves != other.moves) return false
        if (isCompleted != other.isCompleted) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pieceOrder.hashCode()
        result = 31 * result + gridSize
        result = 31 * result + (selectedIndex?.hashCode() ?: 0)
        result = 31 * result + moves
        result = 31 * result + isCompleted.hashCode()
        return result
    }
} 