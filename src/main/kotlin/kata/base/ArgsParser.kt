package kata.base

class ArgsParser {
    private companion object {
        val FLAG = "-l"
        val SCHEMA = setOf(FLAG)
    }

    infix fun parse(arguments: Set<String>): Set<Flag> {
        require(SCHEMA.containsAll(arguments))
        return setOf(Flag(FLAG, FLAG in arguments))
    }
}
