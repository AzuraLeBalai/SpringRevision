class SomeClass {
    public fun a() {
        println(42)
    }

    fun b() {
        a()
    }

    fun c() {
        this.b()
    }
}
