class Robot2 {
    private var x: Int = 0
    private var y: Int = 0

    fun right(steps: Int) {
        x += steps
    }

    fun left(steps: Int) {
        x -= steps
    }

    fun down(steps: Int) {
        y += steps
    }

    fun up(steps: Int) {
        y -= steps
    }

    fun getLocation(): String {
        return "($x, $y)"
    }
}
