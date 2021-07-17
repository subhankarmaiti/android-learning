import java.util.*
fun main() {
    var listOfUsers = HashMap<Int, String>()
    listOfUsers[123] = "Subhankar"
    listOfUsers[554] = "Jena"
    listOfUsers[12] = "Lava"
    for(key in listOfUsers.keys) {
        println("$key: ${listOfUsers[key]}")
    }
}