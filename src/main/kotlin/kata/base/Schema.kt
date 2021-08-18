package kata.base

data class Schema(val flagIndicators: Set<Flag>) {
    infix fun matches(arguments: Set<String>): Boolean {
        return flagIndicators.map { it.indicator }.containsAll(arguments)
    }
}
