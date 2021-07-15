import java.util.*

fun main() {
    print("Enter Year of Birth: ")
    val yearOfBirth = readLine()!!.toInt()
    val yearInDevices = Calendar.getInstance().get(Calendar.YEAR)
    val age = yearInDevices - yearOfBirth

    println("You are $age years old")
}