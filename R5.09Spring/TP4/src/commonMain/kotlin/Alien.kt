class Alien(val name: String, val species: String, private var planet: String) {

    fun movePlanet(newPlanet: String) {
        planet = newPlanet
    }

    override fun toString(): String {
        return "Alien $name, $species: $planet"
    }
}
