package kata.base

class ArgsParser {
    private companion object {
        val FIRST_FLAG = "-l"
        val SECOND_FLAG = "-p"
        val SCHEMA = setOf(FIRST_FLAG, SECOND_FLAG)
    }

    infix fun parse(arguments: Set<String>): Set<Flag> {
        require(SCHEMA.containsAll(arguments))
        return SCHEMA
            .map { Flag(it, it in arguments) }
            .toSet()
    }
}
