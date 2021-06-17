fun main() {
    val name = "Subhankar" //not updatable val
    val age = 25
    val GPA = 4.5
    println("==== User info ====")
    println("Name: $name")
    println("Age: $age")
    println("GPA: $GPA")

    var count = 1 // Editable var
    println("Count: $count")
    count = 10
    println("Count: $count")

    var department: String?
    department = null
    department = "Software Engineering"
    print("Department ${department!!}")

}