package com.car.maintain
class Car(var type:String, val model:Int, val price:Double, val milesDrive:Int, val owner:String) {
    init {
        println("Object class is created")
    }
    fun getCarPrice():Double {
        val priceTotal = this.price - (this.milesDrive.toDouble()*10)
        return priceTotal
    }
}


fun main() {
    /*
    val car1 = Car("BMW",2015,10000.0,105,"Subhankar")
    car1.type = "KIA"
    println(car1.type)
    println(car1.owner)
    println(car1.getCarPrice())

    val car2 = Car("Toyota", 2019, 39000.0, 10, "Jena")
    println(car2.type)
    println(car2.owner)
    println(car2.getCarPrice())
    */
    // List of cars
    val listOfCar = arrayListOf<Car>()
    listOfCar.add(Car("BMW",2015,10000.0,105,"Subhankar"))
    listOfCar.add(Car("Toyota", 2019, 39000.0, 10, "Jena"))
    for(car:Car in listOfCar) {
        println("-----------")
        println(car.owner)
        println(car.getCarPrice())
    }
}