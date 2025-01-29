class Hamster(val name: String) {
    override fun toString(): String {
        return "Hamster('$name')"
    }
}

class Cage(private val maxCapacity: Int) {
    private val hamsters =
        mutableListOf<Hamster>()
    private val empty = true;

    val capacity: Int
        get() = maxCapacity - hamsters.size

    val full: Boolean
        get() = hamsters.size == maxCapacity

    /* add 'empty' property here */

    fun put(hamster: Hamster): Boolean =
        if (full)
            false
        else {
            hamsters += hamster
            true
        }

    fun takeHamster(): Hamster =
        hamsters.removeAt(0)
}