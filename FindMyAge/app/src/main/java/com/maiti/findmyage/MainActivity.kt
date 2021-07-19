package com.maiti.findmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getAgeButton = findViewById<Button>(R.id.buttonAge)
        getAgeButton.setOnClickListener{
            onClickGetAge()
        }

    }

    private fun onClickGetAge() {

        val ageInput = findViewById<EditText>(R.id.edDOB)
        val tvShowAge = findViewById<TextView>(R.id.tvShowAge)
        val userDOB = Integer.parseInt(ageInput.text.toString())
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val userAgeInYears = currentYear - userDOB
        tvShowAge.text = "Your Age is $userAgeInYears Years"
        Log.d("LogsMe","Your Age is $userAgeInYears Years")
    }
}