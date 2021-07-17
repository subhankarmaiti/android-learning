import java.util.*
fun main() {
    println("Pets App")
    print("Enter number of Pets: ")
    val maxSize = readLine()!!.toInt()
    var listOfPets = LinkedList<String>()
    for(i in 0 until maxSize) {
        listOfPets.add(readLine()!!.toString())
    }
    // pets are using index
    for(i in 0 until listOfPets.size) {
        println("Pet $i: ${listOfPets[i]}")
    }
    // pets are using object
    for(pet in listOfPets) {
        println("Pet: $pet")
    }
    
}