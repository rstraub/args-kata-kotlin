package kata.base

class ArgsParser {
    private companion object {
        val FLAG = "-l"
        val SCHEMA = setOf(FLAG)
    }

    infix fun parse(arguments: Set<String>): Flag {
        require(SCHEMA.containsAll(arguments))
        return Flag(FLAG, FLAG in arguments)
    }
}
