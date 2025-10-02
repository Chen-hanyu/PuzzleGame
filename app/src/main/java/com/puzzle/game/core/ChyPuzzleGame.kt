package com.puzzle.game.core

import com.puzzle.game.model.ChyGameState

class ChyPuzzleGame(private val gridSize: Int) {
    private var pieceOrder: MutableList<Int> = MutableList(gridSize * gridSize) { it }
    private var selectedIndex: Int? = null
    private var moves: Int = 0
    private var isCompleted: Boolean = false

    init {
        shufflePieces()
        checkCompletion()
    }

    private fun shufflePieces() {
        do {
            pieceOrder.shuffle()
        } while (isCompleted)
        moves = 0
        isCompleted = false
    }

    fun selectPiece(index: Int): Boolean {
        if (selectedIndex == null) {
            selectedIndex = index
            return false
        } else {
            if (selectedIndex != index) {
                swapPieces(selectedIndex!!, index)
                selectedIndex = null
                return true
            } else {
                selectedIndex = null
                return false
            }
        }
    }

    private fun swapPieces(i: Int, j: Int) {
        val tmp = pieceOrder[i]
        pieceOrder[i] = pieceOrder[j]
        pieceOrder[j] = tmp
        moves++
        checkCompletion()
    }

    private fun checkCompletion() {
        isCompleted = pieceOrder.withIndex().all { it.index == it.value }
    }

    fun getGameState(): ChyGameState {
        return ChyGameState(
            pieceOrder = pieceOrder.toList(),
            gridSize = gridSize,
            selectedIndex = selectedIndex,
            moves = moves,
            isCompleted = isCompleted
        )
    }

    fun resetGame() {
        pieceOrder = MutableList(gridSize * gridSize) { it }
        shufflePieces()
    }

    fun restore() {
        pieceOrder = MutableList(gridSize * gridSize) { it }
        moves = 0
        isCompleted = true
        selectedIndex = null
    }
} 