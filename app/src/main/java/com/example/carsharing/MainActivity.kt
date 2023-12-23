package com.example.carsharing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var colH: EditText
    private var moneyCar: Int = 2000
    private lateinit var discountSeekBar: SeekBar
    private lateinit var discountValueTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        colH = findViewById(R.id.editText)
        discountSeekBar = findViewById(R.id.discountSeekBar)
        discountValueTextView = findViewById(R.id.discountValueTextView)
        discountSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Обновляем текстовое поле с текущим значением скидки
                val discountValue = "$progress%"
                discountValueTextView.text = discountValue
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Ничего не делаем при начале трекинга
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Ничего не делаем при завершении трекинга
            }
        })
        button.setOnClickListener {
            val currentValue = discountSeekBar.progress
            val discountCoefficient = currentValue.toDouble() / 100
            val discountedAmount = moneyCar - (moneyCar * discountCoefficient)
            val answer = discountedAmount * Integer.parseInt(colH.text.toString().trim())
            val intent = SecondActivity.newIntent(this@MainActivity, answer.toInt())
            startActivity(intent)
        }

    }
}
