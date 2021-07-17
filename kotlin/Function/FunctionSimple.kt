fun addNumber(x:Double, y:Double):Double {
    return x+y
}
fun main() {
    var x = readLine()!!.toDouble()
    var y = readLine()!!.toDouble()
    println(addNumber(x,y))
}