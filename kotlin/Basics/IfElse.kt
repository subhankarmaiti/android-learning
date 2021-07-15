fun main() {
    // print("Enter your age: ")
    // var age = readLine()!!.toInt()

    // if(age>60) {
    //     println("You could withdraw your 50K")
    // }

    print("Enter your number: ")
    val number = readLine()!!.toInt()

    if(number>=90) {
        println("A")
    }
    else if(number in 80..89){
        println("B")
    }
    else if(number in 70..79) {
        println("C")
    }
    else {
        println("Fail")
    }
}