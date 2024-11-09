package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var result: TextView;
    private lateinit var history: TextView;
    private lateinit var newNumber: EditText;
    private var operant1: Double? = null;
    private var operant2: Double = 0.0;
    private var pendingOperation = "=";

    //    private val displayOperation by lazy { findViewById(R.id.result) }
    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.result) } // TextView
    private val displayHistory by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.history) } // TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolBar)
        toolbar.title = "Calculator"
        setSupportActionBar(toolbar)


        result = findViewById<TextView>(R.id.result)
        newNumber = findViewById<EditText>(R.id.editTextNumber)
// numbers
        var btn0 = findViewById<Button>(R.id.button0)
        var btn1 = findViewById<Button>(R.id.button1)
        var btn2 = findViewById<Button>(R.id.button2)
        var btn3 = findViewById<Button>(R.id.button3)
        var btn4 = findViewById<Button>(R.id.button4)
        var btn5 = findViewById<Button>(R.id.button5)
        var btn6 = findViewById<Button>(R.id.button6)
        var btn7 = findViewById<Button>(R.id.button7)
        var btn8 = findViewById<Button>(R.id.button8)
        var btn9 = findViewById<Button>(R.id.button9)
        var btnDot = findViewById<Button>(R.id.buttondot)

        //operations
        var btnSum = findViewById<Button>(R.id.buttonSum)
        var btnSub = findViewById<Button>(R.id.buttonsub)
        var btnMulti = findViewById<Button>(R.id.buttonMult)
        var btnDvd = findViewById<Button>(R.id.buttonDivide)
        var btnPerc = findViewById<Button>(R.id.buttonPer)
        var btnPm = findViewById<Button>(R.id.buttonPm)
        var btnEqual = findViewById<Button>(R.id.buttonEqual)

        var btnAC = findViewById<Button>(R.id.buttonAc)
        var btnCE = findViewById<Button>(R.id.buttonCe)

        val listener = View.OnClickListener { v ->
            val b = v as Button
            newNumber.append(b.text)
        }
        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);


        val opListener = View.OnClickListener { v ->
            val op = (v as Button).text.toString()
            val value = newNumber.text.toString()
            if (value.isNotEmpty()) {
                performOperation(value, op)
            }
            pendingOperation = op
           // displayOperation.text = pendingOperation
        }

        btnAC.setOnClickListener(View.OnClickListener { v-> result.text=""; newNumber.setText(""); history.setText("") })

        btnEqual.setOnClickListener(opListener);
        btnSub.setOnClickListener(opListener)
        btnSum.setOnClickListener(opListener)
        btnMulti.setOnClickListener(opListener)
        btnDvd.setOnClickListener(opListener)
        btnPerc.setOnClickListener(opListener)
        btnPm.setOnClickListener(opListener)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun performOperation(value: String, operation: String) {
        println(value)
        println(operation)
        if (operant1 == null) {
            operant1 = value.toDouble()
        } else {
            operant2 = value.toDouble()
            if (pendingOperation === "=") {
                pendingOperation = operation
            }
            when (operation) {
                "=" -> operant1 = operant2
                "x" -> operant1 = operant1!! * operant2
                "-" -> operant1 = operant1!! - operant2
                "+" -> operant1 = operant1!! + operant2
                "/" -> if (operant2 == 0.0) {
                    operant1 = Double.NaN
                } else {
                    operant1 = operant1!! / operant2
                }
            }
        }

        displayHistory.append(operation)
        displayHistory.append(operant1.toString())
        newNumber.setText("")
      displayOperation.setText(operant1.toString())
       // displayOperation.text = operation
    }
}