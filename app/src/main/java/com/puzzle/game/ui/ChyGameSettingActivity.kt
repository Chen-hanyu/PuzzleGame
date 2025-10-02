package com.puzzle.game.ui

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.puzzle.game.R

class ChyGameSettingActivity : AppCompatActivity() {
    private lateinit var imagePreview: ImageView
    private lateinit var selectImageButton: MaterialButton
    private lateinit var startGameButton: MaterialButton
    private lateinit var inputGridSize: EditText
    private var selectedImageUri: Uri? = null

    companion object {
        private const val REQUEST_CODE_PICK_IMAGE = 2001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_setting_chy)

        imagePreview = findViewById(R.id.imagePreview)
        selectImageButton = findViewById(R.id.selectImageButton)
        startGameButton = findViewById(R.id.startGameButton)
        inputGridSize = findViewById(R.id.inputGridSize)

        selectImageButton.setOnClickListener {
            Intent(Intent.ACTION_OPEN_DOCUMENT).also { intent ->
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.type = "image/*"
                intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
            }
        }

        startGameButton.setOnClickListener {
            val gridSizeStr = inputGridSize.text.toString().trim()
            val gridSize = gridSizeStr.toIntOrNull()
            if (gridSize == null || gridSize < 2 || gridSize > 10) {
                Toast.makeText(this, "请输入2~10之间的整数作为难度", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (selectedImageUri == null) {
                Toast.makeText(this, "请选择一张图片", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Intent(this, ChyGameActivity::class.java).also { intent ->
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                intent.putExtra("imageUri", selectedImageUri.toString())
                intent.putExtra("gridSize", gridSize)
                startActivity(intent)
            }
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                selectedImageUri = uri

                contentResolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
                contentResolver.openInputStream(uri)?.use { inputStream ->
                    val bitmap = BitmapFactory.decodeStream(inputStream)
                    imagePreview.setImageBitmap(bitmap)
                }
            }
        }
    }
}
