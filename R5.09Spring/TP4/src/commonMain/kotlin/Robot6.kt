class Robot6(private var x: Int, private var y: Int, private val size: Int) {

    fun right(steps: Int) {
        x = (x + steps) % size
    }

    fun left(steps: Int) {
        x = (x - steps + size) % size
    }

    fun down(steps: Int) {
        y = (y + steps) % size
    }

    fun up(steps: Int) {
        y = (y - steps + size) % size
    }

    fun getLocation(): String {
        return "($x, $y)"
    }

    override fun toString(): String {
        return "Robot(x=$x, y=$y)"
    }
}
