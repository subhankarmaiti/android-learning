package com.maiti.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // load animals
        listOfAnimals.add(Animal("Baboon","Baboon live in big place with tree",R.drawable.baboon,false))
        listOfAnimals.add(Animal("Bulldog","Bulldog live in big place with tree",R.drawable.bulldog,false))
        listOfAnimals.add(Animal("Panda","Panda live in big place with tree",R.drawable.panda,true))
        listOfAnimals.add(Animal("Swallow","Swallow live in big place with tree",R.drawable.swallow_bird,false))
        listOfAnimals.add(Animal("Tiger","Tiger live in big place with tree",R.drawable.white_tiger,false))
        listOfAnimals.add(Animal("Zebra","Zebra live in big place with tree",R.drawable.zebra,true))
        adapter = AnimalsAdapter(this, listOfAnimals)
        val tvListAnimal = findViewById<ListView>(R.id.tvListAnimal)
        tvListAnimal.adapter = adapter
    }
    fun delete(index: Int) {
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }
    fun add(index: Int) {
        listOfAnimals.add(index, listOfAnimals[index])
        adapter!!.notifyDataSetChanged()
    }
    inner class AnimalsAdapter:BaseAdapter {
        var listOfAnimals = ArrayList<Animal>()
        var ctx:Context? = null
        constructor(ctx:Context, listOfAnimals:ArrayList<Animal>):super() {
            this.listOfAnimals = listOfAnimals
            this.ctx = ctx
        }
        override fun getCount(): Int {
            return listOfAnimals.size
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal:Animal = getItem(p0) as Animal

            var inflater = ctx?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView:View?=null
            myView = if(!animal.isKiller) {
                inflater.inflate(R.layout.animal_ticket, null)
            } else {
                inflater.inflate(R.layout.animal_killer_ticket, null)
            }
            val tvName = myView.findViewById<TextView>(R.id.tvName)
            val tvDes = myView.findViewById<TextView>(R.id.tvDes)
            val ivName = myView.findViewById<ImageView>(R.id.ivName)
            ivName.setOnClickListener{
                // delete(p0)
                // add(p0)
                val intent = Intent(ctx, AnimalInfo::class.java)
                intent.putExtra("name", animal.name)
                intent.putExtra("des", animal.des)
                intent.putExtra("image", animal.image)
                ctx!!.startActivity(intent!!)
            }
            tvName.text = animal.name
            Log.d("myLog","name is ${animal.name}")
            tvDes.text = animal.des
            animal.image?.let { ivName.setImageResource(it) }
            return myView
        }

    }
}