package com.puzzle.game.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/puzzle/game/core/ChyPuzzleGame;", "", "gridSize", "", "(I)V", "isCompleted", "", "moves", "pieceOrder", "", "selectedIndex", "Ljava/lang/Integer;", "checkCompletion", "", "getGameState", "Lcom/puzzle/game/model/ChyGameState;", "resetGame", "restore", "selectPiece", "index", "shufflePieces", "swapPieces", "i", "j", "app_debug"})
public final class ChyPuzzleGame {
    private final int gridSize = 0;
    private java.util.List<java.lang.Integer> pieceOrder;
    private java.lang.Integer selectedIndex;
    private int moves = 0;
    private boolean isCompleted = false;
    
    public ChyPuzzleGame(int gridSize) {
        super();
    }
    
    private final void shufflePieces() {
    }
    
    public final boolean selectPiece(int index) {
        return false;
    }
    
    private final void swapPieces(int i, int j) {
    }
    
    private final void checkCompletion() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.puzzle.game.model.ChyGameState getGameState() {
        return null;
    }
    
    public final void resetGame() {
    }
    
    public final void restore() {
    }
}