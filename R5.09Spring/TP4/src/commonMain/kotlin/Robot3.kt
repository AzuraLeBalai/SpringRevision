class Robot3 {
    private var x: Int = 0
    private var y: Int = 0
    private val fieldSize = 100

    fun right(steps: Int) {
        x = (x + steps) % fieldSize
    }

    fun left(steps: Int) {
        x = (x - steps + fieldSize) % fieldSize
    }

    fun down(steps: Int) {
        y = (y + steps) % fieldSize
    }

    fun up(steps: Int) {
        y = (y - steps + fieldSize) % fieldSize
    }

    fun getLocation(): String {
        return "($x, $y)"
    }
}
