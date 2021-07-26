package com.maiti.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buNumbersEvent(view: View) {
        val textArea = findViewById<EditText>(R.id.etShowNumber)
        if(isNewOp) {
            textArea.setText("")
        }
        isNewOp = false
        val buSelected = view as AppCompatButton
        var buClickValue: String = textArea.text.toString()
        when(buSelected.id) {
            R.id.bu0 -> buClickValue += "0"
            R.id.bu1 -> buClickValue += "1"
            R.id.bu2 -> buClickValue += "2"
            R.id.bu3 -> buClickValue += "3"
            R.id.bu4 -> buClickValue += "4"
            R.id.bu5 -> buClickValue += "5"
            R.id.bu6 -> buClickValue += "6"
            R.id.bu7 -> buClickValue += "7"
            R.id.bu8 -> buClickValue += "8"
            R.id.bu9 -> buClickValue += "9"
            R.id.buDot -> {
                if(!buClickValue.contains('.')) {
                    buClickValue += "."
                }
            }
            R.id.buPlsMinus -> {
                if(buClickValue[0] != '-') {
                    buClickValue = "-$buClickValue"
                }else {
                    buClickValue = buClickValue.drop(1)
                }
            }
        }
        textArea.setText(buClickValue)
    }
    var op = "*"
    var oldNumber=""
    var isNewOp = true
    fun buOpEvent(view: View) {
        val textArea = findViewById<EditText>(R.id.etShowNumber)
        val buSelected = view as AppCompatButton
        var buClickValue: String = textArea.text.toString()
        when(buSelected.id) {
            R.id.buMul -> {
                op="*"
            }
            R.id.buDiv -> {
                op="/"
            }
            R.id.buSub -> {
                op="-"
            }
            R.id.buSum -> {
                op="+"
            }
        }
        oldNumber = textArea.text.toString()
        isNewOp = true
    }

    fun buEqualEvent(view: View) {
        val textArea = findViewById<EditText>(R.id.etShowNumber)
        val newNumber = textArea.text.toString()
        var finalNumber:Double? = null
        when(op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
        }
        textArea.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercentEvent(view: View) {
        val textArea = findViewById<EditText>(R.id.etShowNumber)
        val number:Double = textArea.text.toString().toDouble()/100
        textArea.setText(number.toString())
        isNewOp = true
    }

    fun buCleanEvent(view: View) {
        val textArea = findViewById<EditText>(R.id.etShowNumber)
        textArea.setText("0")
        isNewOp = true
        oldNumber=""
    }
}