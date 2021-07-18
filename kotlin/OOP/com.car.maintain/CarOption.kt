package com.car.maintain
open class CarOption {
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