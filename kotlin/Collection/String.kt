fun main() {
    val message = " Welcome to India"
    val name = "Subhankar"
    val allMessage = "$name,$message"
    println(message)
    println(message.trim())
    println(allMessage.lowercase())
    println(allMessage.uppercase())
    val tokens = message.trim().split(" ")
    for(token in tokens) {
        if(!token.contains("to") && !token.contains("is")) {
            println("token: $token")
        }
    }
}