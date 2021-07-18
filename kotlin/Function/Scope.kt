// can not write equal function inside same package
// variable will be present in the scope. can not use outside the scope
var globalVariable:String?=null // it is a global variable to access and modify all over the place
fun showUserInfo(name: String) {
    print(globalVariable)
    println(name)
}

fun main() {
    var name= "Subhankar" //local variable to main. not accessible outside main
    globalVariable="Welcome "
    showUserInfo(name)
}