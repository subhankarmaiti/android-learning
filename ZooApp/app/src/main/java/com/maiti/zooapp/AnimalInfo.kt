package com.maiti.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val des = bundle!!.getString("des")
        val image = bundle!!.getInt("image")
        val ivAnimalImage = findViewById<ImageView>(R.id.ivAnimalImage)
        val tvAnimalName = findViewById<TextView>(R.id.tvAnimalName)
        val tvAnimalDes = findViewById<TextView>(R.id.tvAnimalDes)
        ivAnimalImage.setImageResource(image)
        tvAnimalName.text = name
        tvAnimalDes.text = des
    }
}