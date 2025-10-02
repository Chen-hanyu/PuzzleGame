package com.puzzle.game.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\u000bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u000bJ\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010\'\u001a\u00020\u001eH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/puzzle/game/viewmodel/ChyGameViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_elapsedTime", "Landroidx/lifecycle/MutableLiveData;", "", "_gameState", "Lcom/puzzle/game/model/ChyGameState;", "_moves", "", "elapsedTime", "Landroidx/lifecycle/LiveData;", "getElapsedTime", "()Landroidx/lifecycle/LiveData;", "gameState", "getGameState", "gridSize", "imageUri", "Landroid/net/Uri;", "moves", "getMoves", "puzzleGame", "Lcom/puzzle/game/core/ChyPuzzleGame;", "timerJob", "Lkotlinx/coroutines/Job;", "getGridSize", "getImageUri", "initGame", "", "onCleared", "resetGame", "restore", "saveScore", "time", "selectPiece", "index", "startTimer", "stopTimer", "app_debug"})
public final class ChyGameViewModel extends androidx.lifecycle.AndroidViewModel {
    private com.puzzle.game.core.ChyPuzzleGame puzzleGame;
    private kotlinx.coroutines.Job timerJob;
    private android.net.Uri imageUri;
    private int gridSize = 3;
    private final androidx.lifecycle.MutableLiveData<com.puzzle.game.model.ChyGameState> _gameState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.puzzle.game.model.ChyGameState> gameState = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _elapsedTime = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Long> elapsedTime = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _moves = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Integer> moves = null;
    
    public ChyGameViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.puzzle.game.model.ChyGameState> getGameState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Long> getElapsedTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getMoves() {
        return null;
    }
    
    public final void initGame(int gridSize, @org.jetbrains.annotations.Nullable
    android.net.Uri imageUri) {
    }
    
    public final void selectPiece(int index) {
    }
    
    public final void resetGame() {
    }
    
    public final void restore() {
    }
    
    private final void startTimer() {
    }
    
    private final void stopTimer() {
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.net.Uri getImageUri() {
        return null;
    }
    
    public final int getGridSize() {
        return 0;
    }
    
    private final void saveScore(long time, int moves) {
    }
}