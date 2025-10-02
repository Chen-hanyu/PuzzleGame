package com.puzzle.game.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.puzzle.game.R

class ChyLoginActivity : AppCompatActivity() {
    private lateinit var usernameInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var loginButton: MaterialButton
    private lateinit var registerButton: MaterialButton
    private lateinit var progressBar: View
    private lateinit var auth: FirebaseAuth
    private var isGooglePlayServicesAvailable = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_chy)

        auth = FirebaseAuth.getInstance()

        usernameInput = findViewById(R.id.usernameInput)
        passwordInput = findViewById(R.id.passwordInput)
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton)
        progressBar = findViewById(R.id.progressBar)

        isGooglePlayServicesAvailable = checkGooglePlayServices()
        loginButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (validateInput(username, password)) {
                if (isGooglePlayServicesAvailable) {
                    performFirebaseLogin(username, password)
                } else {
                    performOfflineLogin(username, password)
                }
            }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, ChyRegisterActivity::class.java)
            intent.putExtra("email", usernameInput.text.toString().trim())
            startActivityForResult(intent, 1001)
        }
        
    }


    private fun validateInput(username: String, password: String): Boolean {
        if (username.isEmpty()) {
            usernameInput.error = "请输入用户名"
            return false
        }
        if (password.isEmpty()) {
            passwordInput.error = "请输入密码"
            return false
        }
        if (password.length < 6) {
            passwordInput.error = "密码长度至少为6位"
            return false
        }
        return true
    }

    private fun performFirebaseLogin(email: String, password: String) {
        showLoading(true)
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                showLoading(false)
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        val db = FirebaseFirestore.getInstance()
                        val userRef = db.collection("users").document(user.uid)
                        val data = mapOf(
                            "uid" to user.uid,
                            "username" to (user.displayName ?: user.email ?: "匿名"),
                            "email" to (user.email ?: "")
                        )
                        userRef.set(data, SetOptions.merge())
                    }
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
                    startGameActivity()
                } else {
                    createNewAccount(email, password)
                }
            }
    }

    private fun createNewAccount(email: String, password: String) {
        showLoading(true)
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                showLoading(false)
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        val db = FirebaseFirestore.getInstance()
                        val userRef = db.collection("users").document(user.uid)
                        val data = mapOf(
                            "uid" to user.uid,
                            "username" to (user.displayName ?: user.email ?: "匿名"),
                            "email" to (user.email ?: "")
                        )
                        userRef.set(data, SetOptions.merge())
                    }
                    Toast.makeText(this, "账户创建成功", Toast.LENGTH_SHORT).show()
                    startGameActivity()
                } else {
                    Toast.makeText(this, "登录失败：${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun performOfflineLogin(username: String, password: String) {
        if (username == "test" && password == "123456") {
            Toast.makeText(this, "离线登录成功", Toast.LENGTH_SHORT).show()
            startGameActivity()
        } else {
            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startGameActivity() {
        startActivity(Intent(this, ChyMainActivity::class.java))
        finish()
    }

    private fun showLoading(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
        loginButton.isEnabled = !show
        registerButton.isEnabled = !show
        usernameInput.isEnabled = !show
        passwordInput.isEnabled = !show
    }

    private fun checkGooglePlayServices(): Boolean {
        return try {
            val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            @Suppress("DEPRECATION")
            val activeNetwork = connectivityManager.activeNetworkInfo
            activeNetwork?.isConnectedOrConnecting == true
        } catch (e: Exception) {
            false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            val email = data?.getStringExtra("email") ?: ""
            usernameInput.setText(email)
            passwordInput.setText("")
            Toast.makeText(this, "注册成功，请登录", Toast.LENGTH_SHORT).show()
        }
    }
}