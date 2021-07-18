data class Person(val name:String, val age:Int, val gender:String)


fun main() {
    val person = Person("Subhankar", 30, "Male")
    println("person.name: ${person.name}")
    println("person.age: ${person.age}")
    println("person.gender: ${person.gender}")
}