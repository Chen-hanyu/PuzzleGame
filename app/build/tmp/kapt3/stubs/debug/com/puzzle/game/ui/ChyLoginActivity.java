package com.puzzle.game.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\"\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/puzzle/game/ui/ChyLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "isGooglePlayServicesAvailable", "", "loginButton", "Lcom/google/android/material/button/MaterialButton;", "passwordInput", "Lcom/google/android/material/textfield/TextInputEditText;", "progressBar", "Landroid/view/View;", "registerButton", "usernameInput", "checkGooglePlayServices", "createNewAccount", "", "email", "", "password", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "performFirebaseLogin", "performOfflineLogin", "username", "showLoading", "show", "startGameActivity", "validateInput", "app_debug"})
public final class ChyLoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.android.material.textfield.TextInputEditText usernameInput;
    private com.google.android.material.textfield.TextInputEditText passwordInput;
    private com.google.android.material.button.MaterialButton loginButton;
    private com.google.android.material.button.MaterialButton registerButton;
    private android.view.View progressBar;
    private com.google.firebase.auth.FirebaseAuth auth;
    private boolean isGooglePlayServicesAvailable = false;
    
    public ChyLoginActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean validateInput(java.lang.String username, java.lang.String password) {
        return false;
    }
    
    private final void performFirebaseLogin(java.lang.String email, java.lang.String password) {
    }
    
    private final void createNewAccount(java.lang.String email, java.lang.String password) {
    }
    
    private final void performOfflineLogin(java.lang.String username, java.lang.String password) {
    }
    
    private final void startGameActivity() {
    }
    
    private final void showLoading(boolean show) {
    }
    
    private final boolean checkGooglePlayServices() {
        return false;
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
}