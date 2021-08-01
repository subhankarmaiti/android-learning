package com.maiti.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    var listOfFoods = ArrayList<Food>()
    var adapter:Adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load foods
        listOfFoods.add(Food("Coffee","Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. All fruit must be further processed from a raw material—the fruit and seed—into a stable, raw product; un-roasted, green coffee.",R.drawable.coffee_pot))
        listOfFoods.add(Food("Espresso","Espresso is a coffee-brewing method of Italian origin, in which a small amount of nearly boiling water is forced under 9–10 bars of pressure through finely-ground coffee beans. Espresso coffee can be made with a wide variety of coffee beans and roast degrees.",R.drawable.espresso))
        listOfFoods.add(Food("French Fries","French fries, or simply fries, chips, finger chips, hot chips or French-fried potatoes, are deep-fried potatoes, which have been cut into batons.",R.drawable.french_fries))
        listOfFoods.add(Food("Honey","Honey is a sweet, viscous food substance made by honey bees and some related insects, such as stingless bees. Bees produce honey from the sugary secretions of plants or from secretions of other insects, by regurgitation, enzymatic activity, and water evaporation.",R.drawable.honey))
        listOfFoods.add(Food("Strawberry","Strawberry ice cream is a flavor of ice cream made with strawberry or strawberry flavoring. It is made by blending in fresh strawberries or strawberry flavoring with the eggs, cream, vanilla and sugar used to make ice cream. Most strawberry ice cream is colored pink or light red.",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar Cubes","Sugar cubes (sometimes called sugar lumps) are white or brown granulated sugars lightly steamed and pressed together in block shape. They are used to sweeten drinks.",R.drawable.sugar_cubes))
        adapter = FoodAdapter(this, listOfFoods)
        val gvListFood = findViewById<GridView>(R.id.gvListFood)
        gvListFood.adapter = adapter as FoodAdapter
    }

    class FoodAdapter:BaseAdapter {
        var listOfFood = ArrayList<Food>()
        var context:Context? = null
        constructor(context:Context, listOfFood: ArrayList<Food>):super() {
            this.context = context
            this.listOfFood = listOfFood
        }
        override fun getCount(): Int {
            return listOfFood.size
        }

        override fun getItem(p0: Int): Any {
            return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food:Food = getItem(p0) as Food
            var inflator:LayoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_ticket, null)
            var ivName = foodView.findViewById<ImageView>(R.id.ivName)
            var tvName = foodView.findViewById<TextView>(R.id.tvName)
            foodView.setOnClickListener{
                val intent = Intent(context, FoodDetails::class.java)
                intent.putExtra("name",food.name)
                intent.putExtra("des",food.des)
                intent.putExtra("image",food.image)
                context!!.startActivity(intent)
            }
            ivName.setBackgroundResource(food.image!!)
            tvName.text = food.name
            return foodView
        }

    }
}