interface CreditCard {
    val cardNumber:String

    fun score(age:Int)
}

class MasterCard(override val cardNumber: String):CreditCard {
    override fun score(age:Int) {
        if(age>50) {
            println("Negative")
        }
        else {
            println("positive")
        }
    }
}

class Visa(override val cardNumber: String):CreditCard {
    override fun score(age:Int) {
        if(age>60) {
            println("Negative")
        }
        else {
            println("positive")
        }
    }
}

fun main() {
    val visa = Visa("123465439861")
    visa.score(60)

    val masterCard = MasterCard("123638339861")
    masterCard.score(60)
}