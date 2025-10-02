package com.puzzle.game.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.puzzle.game.R

class ChyRegisterActivity : AppCompatActivity() {
    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var registerButton: MaterialButton
    private lateinit var progressBar: View
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_chy)

        auth = FirebaseAuth.getInstance()
        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)
        registerButton = findViewById(R.id.registerButton)
        progressBar = findViewById(R.id.progressBar)

        val email = intent.getStringExtra("email") ?: ""
        emailInput.setText(email)

        registerButton.setOnClickListener {
            val emailText = emailInput.text.toString().trim()
            val passwordText = passwordInput.text.toString().trim()
            if (validateInput(emailText, passwordText)) {
                doRegister(emailText, passwordText)
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            emailInput.error = "请输入邮箱"
            return false
        }
        val pattern = "[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$".toRegex()
        if (pattern.matches(email)){
            passwordInput.error = "邮箱格式错误"
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

    private fun doRegister(email: String, password: String) {
        showLoading(true)
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                showLoading(false)
                if (task.isSuccessful) {
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show()
                    val intent = Intent()
                    intent.putExtra("email", email)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                } else {
                    Toast.makeText(this, "注册失败：${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun showLoading(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
        registerButton.isEnabled = !show
        emailInput.isEnabled = !show
        passwordInput.isEnabled = !show
    }
}