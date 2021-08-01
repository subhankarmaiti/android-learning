package com.maiti.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FoodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val bundle = intent.extras
        val ivFoodImage = findViewById<ImageView>(R.id.ivFoodImage)
        val tvFoodName = findViewById<TextView>(R.id.tvFoodName)
        val tvFoodDes = findViewById<TextView>(R.id.tvFoodDes)

        ivFoodImage.setImageResource(bundle!!.getInt("image"))
        tvFoodName.text = bundle!!.getString("name")
        tvFoodDes.text = bundle!!.getString("des")
    }
}