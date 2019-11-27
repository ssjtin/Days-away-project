package com.example.daysawayproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private val ADD_TASK_REQUEST = 1
    private lateinit var result: EditText

    var currentTotal: Float = 0.0f
    var newNumber: Float = 0.0f
    var pendingOperation: CharSequence? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonDecimal: Button = findViewById(R.id.buttonDecimal)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonResult: Button = findViewById(R.id.buttonResult)

        result = findViewById(R.id.resultTextEdit)

        val operationListener = View.OnClickListener { v ->
            val button = v as Button
            performOperation(button.text)
        }

        val numberListener = View.OnClickListener { v ->
            val button = v as Button
            numberPressed(button.text)
        }

        button0.setOnClickListener(numberListener)
        button1.setOnClickListener(numberListener)
        button2.setOnClickListener(numberListener)
        button3.setOnClickListener(numberListener)
        button4.setOnClickListener(numberListener)
        button5.setOnClickListener(numberListener)
        button6.setOnClickListener(numberListener)
        button7.setOnClickListener(numberListener)
        button8.setOnClickListener(numberListener)
        button9.setOnClickListener(numberListener)
        buttonDecimal.setOnClickListener(numberListener)

        buttonAdd.setOnClickListener(operationListener)
        buttonMinus.setOnClickListener(operationListener)
        buttonMultiply.setOnClickListener(operationListener)
        buttonDivide.setOnClickListener(operationListener)
        buttonResult.setOnClickListener(operationListener)

        goToTestingActivity()
    }

    private fun performOperation(input: CharSequence) {

        val number: Float = result.text.toString().toFloat()

        if (input == "=" && (pendingOperation == null)) {
            return
        }

        if (input == "=") {
            newNumber = number
            calculate()
            pendingOperation = "="
            return
        }

        currentTotal = number
        result.text.clear()
        pendingOperation = input

    }

    private fun numberPressed(input: CharSequence) {
        if (pendingOperation == "=") {
            result.text.clear()
            pendingOperation = null
        }

        result.append(input)
        if (result.text.toString() == "58008") {
            presentActivity()
        }

    }

    private fun calculate() {
        var calculationResult = 0f
        when (pendingOperation) {
            "+" -> calculationResult = currentTotal + newNumber
            "-" -> calculationResult = currentTotal - newNumber
            "*" -> calculationResult = currentTotal * newNumber
            "/" -> calculationResult = currentTotal / newNumber
        }
        result.setText(calculationResult.toString())

        currentTotal = calculationResult
        pendingOperation = "="
        newNumber = 0f
    }

    private fun presentActivity() {
        val intent = Intent(this, SecretPuzzleActivity::class.java)
        startActivityForResult(intent, ADD_TASK_REQUEST)
    }

    private fun goToTestingActivity() {
        val intent = Intent(this, PuzzleTestingActivity::class.java)
        startActivityForResult(intent, ADD_TASK_REQUEST)
    }


}
