fun main() {
    for(i in 1..5) {
        println("Hello World")
    }
    // Increment
    for( i in 1..100 step 2) {
        println("Number is $i")
    }
    // Decrement
    for( i in 100 downTo 0 step 2) {
        println("Number is $i")
    }
    // While loop
    var j = 1
    while(j<=10) {
        println("Counter $j")
        j++
    }

    // do while
    j = 1
    do {
        println("Counter $j")
        j++
    }while(j<=10)
}