fun main() {
    val foodID = readLine()!!.toInt()

    when(foodID) {
        1 -> {
            println("You got sandwitch")
        }
        10 -> {
            println("You got burger")
        }
        else -> {
            println("You did not order anything")
        }
    }
}