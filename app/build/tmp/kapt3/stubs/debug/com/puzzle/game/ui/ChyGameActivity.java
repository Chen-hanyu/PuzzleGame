package com.puzzle.game.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\tH\u0002J%\u0010 \u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0002\u0010#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/puzzle/game/ui/ChyGameActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnBack", "Lcom/google/android/material/button/MaterialButton;", "btnRestore", "gridLayout", "Landroid/widget/GridLayout;", "gridSize", "", "imageUri", "Landroid/net/Uri;", "pieceBitmaps", "", "Landroid/graphics/Bitmap;", "tvMoves", "Landroid/widget/TextView;", "tvTimer", "viewModel", "Lcom/puzzle/game/viewmodel/ChyGameViewModel;", "adjustCardPuzzleRatio", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "restorePuzzleGrid", "setupClickListeners", "setupObservers", "showOriginalImage", "splitImageToPieces", "uri", "n", "updateGrid", "pieceOrder", "selectedIndex", "(Ljava/util/List;Ljava/lang/Integer;)V", "app_debug"})
public final class ChyGameActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.puzzle.game.viewmodel.ChyGameViewModel viewModel;
    private android.widget.GridLayout gridLayout;
    private android.widget.TextView tvTimer;
    private android.widget.TextView tvMoves;
    private com.google.android.material.button.MaterialButton btnRestore;
    private com.google.android.material.button.MaterialButton btnBack;
    private java.util.List<android.graphics.Bitmap> pieceBitmaps;
    private int gridSize = 3;
    private android.net.Uri imageUri;
    
    public ChyGameActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupObservers() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void updateGrid(java.util.List<java.lang.Integer> pieceOrder, java.lang.Integer selectedIndex) {
    }
    
    private final java.util.List<android.graphics.Bitmap> splitImageToPieces(android.net.Uri uri, int n) {
        return null;
    }
    
    private final void adjustCardPuzzleRatio() {
    }
    
    private final void showOriginalImage() {
    }
    
    private final void restorePuzzleGrid() {
    }
}