package kata.base

data class Schema(val flagIndicators: Set<String>) {
    infix fun matches(arguments: Set<String>): Boolean {
        return flagIndicators.containsAll(arguments)
    }
}
