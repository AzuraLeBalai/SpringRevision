class Giraffe {
    fun displayID() {
        val id = this.toString().substringAfter('@')
        println("Giraffe ID: $id")
    }
}
