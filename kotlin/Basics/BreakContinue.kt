fun main() {
    for(number in 1..10) {
        if(number==5) {
            continue
        }
        println("Number $number")
        if(number == 9) {
            break
        }
        if(number == 8) {
            return
        }
    }

    loop@ for(number in 1..10) {
        println("Outer Number: $number")
        for(innerNumber in 1..7) {
            println("Inner Number: $innerNumber")
            if(innerNumber==6) {
                break@loop
            }
        }
    }

}