package kata.base

class ArgsParser {
    private companion object {
        val FLAG = "-l"
        val SCHEMA = setOf(FLAG)
    }

    infix fun parse(arguments: Set<String>): Boolean {
        if(!SCHEMA.containsAll(arguments))
            throw IllegalArgumentException()
        return FLAG in arguments
    }
}
