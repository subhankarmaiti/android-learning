package com.car.maintain

class Truck:CarOption {

    var subType: String?=null
    constructor(type:String, model:Int, price:Double, milesDrive:Int, owner:String, subType:String):super(type, model, price, milesDrive, owner) {
        this.subType = subType
    }
    constructor(type:String, model:Int, price:Double, milesDrive:Int, subType: String):super(type, model, price, milesDrive) {
        this.subType = subType
    }
    fun getCarPrice():Double {
        val priceTotal = this.price!! - (this.milesDrive!!.toDouble()*10)
        return priceTotal
    }
}


fun main() {
    val truck1 = Truck("BMW",2015,10000.0,105,"Subhankar","Dump")
    truck1.type = "KIA"
    println(truck1.type)
    println(truck1.owner)
    println(truck1.getCarPrice())

    val truck2 = Truck("Toyota", 2019, 39000.0, 10,"Garbage")
    println(truck2.type)
    println(truck2.owner)
    println(truck2.getCarPrice())
    
}