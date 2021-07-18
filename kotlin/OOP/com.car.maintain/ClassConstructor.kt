package com.car.maintain
class ClassConstructor {
    var type:String?=null
    var model:Int?= null
    var price:Double?=null
    var milesDrive:Int?=null
    var owner:String?=null
    constructor(type:String, model:Int, price:Double, milesDrive:Int, owner:String) {
        this.type = type
        this.model = model
        this.price = price
        this.milesDrive = milesDrive
        this.owner = owner
    }
    constructor(type:String, model:Int, price:Double, milesDrive:Int) {
        this.type = type
        this.model = model
        this.price = price
        this.milesDrive = milesDrive
    }
    fun getCarPrice():Double {
        val priceTotal = this.price!! - (this.milesDrive!!.toDouble()*10)
        return priceTotal
    }
}


fun main() {
    val car1 = ClassConstructor("BMW",2015,10000.0,105,"Subhankar")
    car1.type = "KIA"
    println(car1.type)
    println(car1.owner)
    println(car1.getCarPrice())

    val car2 = ClassConstructor("Toyota", 2019, 39000.0, 10)
    println(car2.type)
    println(car2.owner)
    println(car2.getCarPrice())
    
}