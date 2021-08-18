package kata.base

data class Schema(val values: Set<String>) {
    infix fun matches(arguments: Set<String>): Boolean {
        return values.containsAll(arguments)
    }
}
