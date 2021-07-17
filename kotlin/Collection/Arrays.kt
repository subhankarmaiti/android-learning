fun main() {
    println("Pets App")
    print("Enter number of Pets: ")
    val maxSize = readLine()!!.toInt()
    var listOfPets: Array<String> = Array(maxSize){""}
    for(i in 0 until maxSize) {
        listOfPets[i] = readLine()!!.toString()
    }
    for(i in 0 until maxSize) {
        println("Pet $i: ${listOfPets[i]}")
    }
    
}