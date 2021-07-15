/**
 * <
 * >
 * <=
 * >=
 * ==
 * !=
 * &&
 * ||
 * !
 * in
 */
fun main() {
    val number = 10

    println(number>=1 && number<=10)

    val age = 17
    println(age<18 || age>60)
    println(age in 18..60) //from 18 to 60 both inclusion
}