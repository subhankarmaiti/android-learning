package com.maiti.pockemonandroid

import android.location.Location

class Pockemon {
    var name:String? = null
    var des:String? = null
    var image:Int? = null
    var power:Double? = null
    var location:Location?=null
    var isCatch:Boolean? = null
    constructor(image:Int, name:String, des:String, power:Double, lat:Double, lng:Double) {
        this.name = name
        this.des = des
        this.image = image
        this.power = power
        this.location = Location(name)
        this.location!!.latitude = lat
        this.location!!.longitude = lng
        this.isCatch = false
    }
}