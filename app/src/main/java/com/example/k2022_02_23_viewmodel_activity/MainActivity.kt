package com.example.k2022_02_23_viewmodel_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.text.set
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider

lateinit var scoreViewModel: ScoreViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var scoreView: EditText
    private lateinit var decrementButton: Button
    private lateinit var incremenetButton: Button
    private lateinit var zeroButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreView = findViewById(R.id.score_view)
        decrementButton = findViewById(R.id.decrement_button)
        incremenetButton = findViewById(R.id.increment_button)
        zeroButton = findViewById(R.id.zero_button)

        scoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)

        scoreViewModel.getScore().observe(this) {
            var str = it?.toString()
            scoreView.setText(str)
        }

        decrementButton.setOnClickListener {
            scoreViewModel.decrement()
        }

        incremenetButton.setOnClickListener {
            scoreViewModel.increment()
        }

        zeroButton.setOnClickListener {
            scoreViewModel.zero()
        }
    }
}