package com.maiti.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.maiti.tictactoe.R.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellId = 0
        when(buSelected.id) {
            id.bu1 -> cellId = 1
            id.bu2 -> cellId = 2
            id.bu3 -> cellId = 3
            id.bu4 -> cellId = 4
            id.bu5 -> cellId = 5
            id.bu6 -> cellId = 6
            id.bu7 -> cellId = 7
            id.bu8 -> cellId = 8
            id.bu9 -> cellId = 9
        }
        playGame(cellId, buSelected)
    }
    private var activePlayer = 1
    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private val buArray = arrayOf(id.bu1, id.bu2, id.bu3, id.bu4, id.bu5, id.bu6, id.bu7, id.bu8, id.bu9)
    private fun playGame(ceilId: Int, buSelected: Button) {
        if(activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(color.blue)
            player1.add(ceilId)
            activePlayer = 2
            autoPlay()
        } else {
            buSelected.text = "0"
            buSelected.setBackgroundResource(color.darkGreen)
            player2.add(ceilId)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()
    }
    private fun checkWinner() {
        var winner = -1

        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        // diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        // diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if(winner == 1) {
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
        }else if(winner == 2) {
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
        }
    }
    private fun autoPlay() {
        val emptyCells = ArrayList<Int>()
        for(cellId in 1..9) {
            if(!(player1.contains(cellId) || player2.contains((cellId)))) {
                emptyCells.add(cellId)
            }
        }
        val r = Random()
        if(!emptyCells.isEmpty()) {
            val randIndex = r.nextInt(emptyCells.size)
            val cellId = emptyCells[randIndex]
            val buSelected: Button?
            buSelected = findViewById(buArray[cellId - 1])
            playGame(cellId, buSelected)
        }
    }
}

