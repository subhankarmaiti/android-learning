/**
 * mutable: You can update, add more
 * im-mutable: You cannot update, you cannot add more
 */
fun main() {
    //1- list

    //im-mutable
    var list = listOf("Jena", "Lava")
    for(name in list) {
        println(name)
    }

    // mutable
    val listMutable = mutableListOf("Jena","Lava")
    listMutable[1] = "Subhankar"
    for (name in listMutable) {
        println(name)
    }

    // 2- Map
    val listOfUser = mapOf(1 to "Subhankar", 2 to "Jena")
    var mutableListOfUser = mutableMapOf(1 to "Subhankar", 2 to "Jena")


    var list = ArrayList<String>()
    var newList = arrayListOf<String>()
    // similar for other collection
}