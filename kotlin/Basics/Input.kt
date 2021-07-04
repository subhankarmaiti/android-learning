/**
 * This App get user info then print them
 */
fun main() {
    // Ask for user name
    print("Enter Name: ")
    val name: String = readLine()!!.toString()
    // Ask for Age
    print("Enter Age: ")
    val age = readLine()!!.toInt()
    // Ask for GPA
    print("Enter GPA: ")
    val GPA = readLine()!!.toDouble()
    println("==== User info ====")
    println("Your Name: $name")
    println("Your Age: $age")
    println("Your GPA: $GPA")

} 