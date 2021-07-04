fun main() {
    print("Enter number1: ")
    val number1 = readLine()!!.toDouble()
    print("Enter number2: ")
    val number2 = readLine()!!.toDouble()

    val sum = number1 + number2
    println("Sum: $sum");

    val sub = number1 - number2
    println("Sub: $sub");

    val mul = number1 * number2
    println("Mul: $mul");

    val div = number1 / number2
    println("Div: $div");
}