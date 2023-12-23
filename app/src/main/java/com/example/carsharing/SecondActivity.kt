package com.example.carsharing

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.widget.TextView

private const val EXTRA = "com.example.carsharing.answer"
class SecondActivity : AppCompatActivity() {
    private var answer = 0
    private lateinit var fullAnswer: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        fullAnswer = findViewById(R.id.textView)
        answer = intent.getIntExtra(EXTRA, 0)
        fullAnswer.setText("Оплатить $answer рублей")
    }

    companion object {
        fun newIntent(packageContext: Context, answer: Float): Intent {
            return Intent(packageContext, SecondActivity::class.java).apply {
                putExtra(EXTRA, answer)
            }
        }
    }

}