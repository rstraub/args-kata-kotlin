package kata.base

class ArgsParser {
    private companion object {
        val FIRST_FLAG = "-l"
        val SECOND_FLAG = "-p"
        val SCHEMA = setOf(FIRST_FLAG, SECOND_FLAG)
    }

    infix fun parse(arguments: Set<String>): Set<Flag> {
        require(SCHEMA.containsAll(arguments))
        val firstFlag = Flag(FIRST_FLAG, FIRST_FLAG in arguments)
        val secondFlag = Flag(SECOND_FLAG, SECOND_FLAG in arguments)
        return setOf(firstFlag, secondFlag)
    }
}
