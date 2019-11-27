package com.example.daysawayproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class SecretPuzzleActivity : AppCompatActivity() {

    private val ADD_TASK_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret_puzzle)

        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            presentActivity()
        }
    }

    private fun presentActivity() {
        val intent = Intent(this, PuzzleTestingActivity::class.java)
        startActivityForResult(intent, ADD_TASK_REQUEST)
    }

}
