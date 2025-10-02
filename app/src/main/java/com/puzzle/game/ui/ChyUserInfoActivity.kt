package com.puzzle.game.ui

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.puzzle.game.R

class ChyUserInfoActivity : AppCompatActivity() {
    private lateinit var tvNickname: TextView
    private lateinit var tvEmail: TextView
    private lateinit var etNickname: EditText
    private lateinit var btnChangeNickname: Button
    private lateinit var etPassword: EditText
    private lateinit var btnChangePassword: Button
    private lateinit var btnLogout: MaterialButton
    private lateinit var btnDeleteAccount: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_chy)

        tvNickname = findViewById(R.id.tvNickname)
        tvEmail = findViewById(R.id.tvEmail)
        etNickname = findViewById(R.id.etNickname)
        btnChangeNickname = findViewById(R.id.btnChangeNickname)
        etPassword = findViewById(R.id.etPassword)
        btnChangePassword = findViewById(R.id.btnChangePassword)
        btnLogout = findViewById(R.id.btnLogout)
        btnDeleteAccount = findViewById(R.id.btnDeleteAccount)

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val user = auth.currentUser

        if (user != null) {
            db.collection("users").document(user.uid).get().addOnSuccessListener { doc ->
                val nickname = doc.getString("username") ?: "未设置"
                val email = doc.getString("email") ?: ""
                tvNickname.text = nickname
                tvEmail.text = email
            }
        }

        btnChangeNickname.setOnClickListener {
            val newNickname = etNickname.text.toString().trim()
            if (newNickname.isNotEmpty() && user != null) {
                db.collection("users").document(user.uid)
                    .update("username", newNickname)
                    .addOnSuccessListener { tvNickname.text = newNickname }
            }
        }

        btnChangePassword.setOnClickListener {
            val newPassword = etPassword.text.toString().trim()
            if (newPassword.length >= 6 && user != null) {
                user.updatePassword(newPassword)
                    .addOnSuccessListener {
                        Toast.makeText(this, "密码修改成功", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "密码修改失败", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        btnLogout.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, ChyLoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        btnDeleteAccount.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("注销账号")
                .setMessage("确定要注销账号吗？")
                .setPositiveButton("确定") { _, _ ->
                    val user = auth.currentUser
                    user?.delete()?.addOnCompleteListener { task ->
                        val intent = Intent(this, ChyLoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        finish()
                    }
                }
                .setNegativeButton("取消", null)
                .show()
        }
    }

    private fun showEditDialog(title: String, targetView: TextView?) {
        val edit = android.widget.EditText(this)
        if (targetView != null) {
            val old = targetView.text.toString().substringAfter(":")
            edit.setText(old)
        }
        AlertDialog.Builder(this)
            .setTitle(title)
            .setView(edit)
            .setPositiveButton("确定") { _, _ ->
                if (targetView != null) {
                    val prefix = targetView.text.toString().substringBefore(":")
                    targetView.text = "$prefix: ${edit.text}"
                }
            }
            .setNegativeButton("取消", null)
            .show()
    }
} 