package com.puzzle.game.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.puzzle.game.R
import com.puzzle.game.viewmodel.ChyGameViewModel
import java.util.concurrent.TimeUnit

class ChyGameActivity : AppCompatActivity() {

    private lateinit var viewModel: ChyGameViewModel
    private lateinit var gridLayout: GridLayout
    private lateinit var tvTimer: TextView
    private lateinit var tvMoves: TextView
    private lateinit var btnRestore: MaterialButton
    private lateinit var btnBack: MaterialButton

    private var pieceBitmaps: List<Bitmap> = emptyList()
    private var gridSize: Int = 3
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_chy)

        gridLayout = findViewById(R.id.puzzleGrid)
        tvTimer    = findViewById(R.id.tvTimer)
        tvMoves    = findViewById(R.id.tvMoves)
        btnRestore = findViewById(R.id.btnRestore)
        btnBack    = findViewById(R.id.btnBack)

        gridLayout.alignmentMode = GridLayout.ALIGN_BOUNDS
        gridLayout.useDefaultMargins = false

        viewModel = ViewModelProvider(this)[ChyGameViewModel::class.java]

        imageUri = intent.getStringExtra("imageUri")?.let { Uri.parse(it) }
        gridSize = intent.getIntExtra("gridSize", 3)

        pieceBitmaps = splitImageToPieces(imageUri, gridSize)

        adjustCardPuzzleRatio()

        viewModel.initGame(gridSize, imageUri)
        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {
        viewModel.gameState.observe(this) { gameState ->
            updateGrid(gameState.pieceOrder, gameState.selectedIndex)
            if (gameState.isCompleted) {
                Toast.makeText(this, "拼图完成！", Toast.LENGTH_LONG).show()
            }
        }
        viewModel.elapsedTime.observe(this) { time ->
            val minutes = TimeUnit.MILLISECONDS.toMinutes(time)
            val seconds = TimeUnit.MILLISECONDS.toSeconds(time) % 60
            tvTimer.text = String.format("时间: %02d:%02d", minutes, seconds)
        }
        viewModel.moves.observe(this) { moves ->
            tvMoves.text = "步数: $moves"
        }
    }

    private fun setupClickListeners() {
        btnRestore.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> { showOriginalImage(); true }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> { restorePuzzleGrid(); true }
                else -> false
            }
        }
        btnBack.setOnClickListener { finish() }
    }

    private fun updateGrid(pieceOrder: List<Int>, selectedIndex: Int?) {
        gridLayout.removeAllViews()
        gridLayout.rowCount = gridSize
        gridLayout.columnCount = gridSize

        val highlightMatrix = ColorMatrix().apply { setScale(1.5f, 1.5f, 1.5f, 1f) }
        val highlightFilter = ColorMatrixColorFilter(highlightMatrix)

        pieceOrder.forEachIndexed { i, pieceIdx ->
            val img = ImageView(this).apply {
                setImageBitmap(pieceBitmaps[pieceIdx])
                colorFilter = if (selectedIndex == i) highlightFilter else null
                setOnClickListener { viewModel.selectPiece(i) }
            }
            img.layoutParams = GridLayout.LayoutParams().apply {
                width = 0
                height = 0
                columnSpec = GridLayout.spec(i % gridSize, 1f)
                rowSpec    = GridLayout.spec(i / gridSize, 1f)
                setMargins(0, 0, 0, 0)
            }
            gridLayout.addView(img)
        }
    }

    private fun splitImageToPieces(uri: Uri?, n: Int): List<Bitmap> {
        val src = uri?.let {
            contentResolver.openInputStream(it).use { BitmapFactory.decodeStream(it) }
        } ?: BitmapFactory.decodeResource(resources, R.drawable.ic_launcher)

        val w = src.width / n
        val h = src.height / n
        return List(n * n) { idx ->
            val r = idx / n
            val c = idx % n
            Bitmap.createBitmap(src, c * w, r * h, w, h)
        }
    }

    private fun adjustCardPuzzleRatio() {
        if (pieceBitmaps.isEmpty()) return
        val bmp = pieceBitmaps[0]
        val totalW = bmp.width * gridSize
        val totalH = bmp.height * gridSize
        val ratio = "$totalW:$totalH"

        val cardView = findViewById<View>(R.id.cardPuzzle)
        val parent   = cardView.parent
        if (parent is ConstraintLayout) {
            ConstraintSet().apply {
                clone(parent)
                setDimensionRatio(cardView.id, ratio)
                applyTo(parent)
            }
        }
    }

    private fun showOriginalImage() {
        gridLayout.removeAllViews()
        gridLayout.rowCount = gridSize
        gridLayout.columnCount = gridSize
        pieceBitmaps.forEachIndexed { i, bmp ->
            val iv = ImageView(this).apply { setImageBitmap(bmp) }
            iv.layoutParams = GridLayout.LayoutParams().apply {
                width = 0; height = 0
                columnSpec = GridLayout.spec(i % gridSize, 1f)
                rowSpec    = GridLayout.spec(i / gridSize, 1f)
                setMargins(0, 0, 0, 0)
            }
            gridLayout.addView(iv)
        }
    }

    private fun restorePuzzleGrid() {
        viewModel.gameState.value?.let { updateGrid(it.pieceOrder, it.selectedIndex) }
    }
}
