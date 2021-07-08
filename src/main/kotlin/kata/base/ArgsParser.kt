package kata.base

class ArgsParser {
    private companion object {
        val FLAG = "-l"
        val SCHEMA = setOf(FLAG)
    }

    infix fun parse(arguments: Set<String>): Boolean {
        require(SCHEMA.containsAll(arguments))
        return FLAG in arguments
    }
}
