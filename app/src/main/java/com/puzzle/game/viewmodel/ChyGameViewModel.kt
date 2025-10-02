package com.puzzle.game.viewmodel

import android.app.Application
import android.content.Context
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.puzzle.game.core.ChyPuzzleGame
import com.puzzle.game.model.ChyGameState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ChyGameViewModel(application: Application) : AndroidViewModel(application) {
    private var puzzleGame: ChyPuzzleGame? = null
    private var timerJob: Job? = null
    private var imageUri: Uri? = null
    private var gridSize: Int = 3
    
    private val _gameState = MutableLiveData<ChyGameState>()
    val gameState: LiveData<ChyGameState> = _gameState
    
    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long> = _elapsedTime
    
    private val _moves = MutableLiveData<Int>()
    val moves: LiveData<Int> = _moves
    
    fun initGame(gridSize: Int, imageUri: Uri?) {
        this.gridSize = gridSize
        this.imageUri = imageUri
        puzzleGame = ChyPuzzleGame(gridSize)
        _gameState.value = puzzleGame?.getGameState()
        _elapsedTime.value = 0L
        _moves.value = 0
        startTimer()
    }
    
    fun selectPiece(index: Int) {
        puzzleGame?.let { game ->
            val swapped = game.selectPiece(index)
            val state = game.getGameState()
            _gameState.value = state
            _moves.value = state.moves
            if (state.isCompleted) {
                stopTimer()
                saveScore(_elapsedTime.value ?: 0L, state.moves)
            }
        }
    }

    fun resetGame() {
        puzzleGame?.resetGame()
        val state = puzzleGame?.getGameState()
        _gameState.value = state
        _elapsedTime.value = 0
        _moves.value = state?.moves ?: 0
        startTimer()
    }

    fun restore() {
        puzzleGame?.restore()
        val state = puzzleGame?.getGameState()
        _gameState.value = state
        _moves.value = state?.moves ?: 0
        stopTimer()
    }
    
    private fun startTimer() {
        stopTimer()
        timerJob = viewModelScope.launch {
            var time = _elapsedTime.value ?: 0L
            while (true) {
                delay(1000)
                time += 1000
                _elapsedTime.value = time
            }
        }
    }
    
    private fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
    }
    
    override fun onCleared() {
        super.onCleared()
        stopTimer()
    }

    fun getImageUri(): Uri? = imageUri
    fun getGridSize(): Int = gridSize

    private fun saveScore(time: Long, moves: Int) {
        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid ?: "guest"
        val prefs = getApplication<Application>().getSharedPreferences("history_scores_$uid", Context.MODE_PRIVATE)
        val set = prefs.getStringSet("scores", mutableSetOf())?.toMutableSet() ?: mutableSetOf()
        val min = time / 60000
        val sec = (time / 1000) % 60
        set.add("用时: %02d:%02d 步数: %d".format(min, sec, moves))
        prefs.edit().putStringSet("scores", set).apply()

        if (user != null) {
            val db = FirebaseFirestore.getInstance()
            val userRef = db.collection("users").document(user.uid)
            userRef.get().addOnSuccessListener { doc ->
                val oldTime = doc.getLong("rankTime")?.toInt() ?: Int.MAX_VALUE
                val newTime = (time / 1000).toInt()
                if (newTime < oldTime) {
                    val data = mapOf(
                        "rankTime" to newTime,
                        "rankMoves" to moves
                    )
                    userRef.update(data)
                }
            }
        }
    }
} 