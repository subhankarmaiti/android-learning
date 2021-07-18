val sum = {number1:Int, number2:Int -> 
    number1 + number2
}

fun main() {
    val addNumber = sum(3,4)
    println("addNumber: $addNumber")

    val listOfNumbers = listOf(10,15,22,34,80)
    println("List of numbers")

    // normal for loop
    for(number in listOfNumbers) {
        println(number)
    }
    // Lamda loop
    listOfNumbers.forEach{ number ->
        println(number)
    }
}