package kata.base

class ArgsParser {
    private companion object {
        val FIRST_INDICATOR = "-l"
        val SECOND_INDICATOR = "-p"
        val SCHEMA = Schema(setOf(FIRST_INDICATOR, SECOND_INDICATOR))
    }

    infix fun parse(arguments: Set<String>): Set<Flag> {
        require(SCHEMA matches arguments)
        return SCHEMA
            .flagIndicators
            .map { parseFlag(it, arguments) }
            .toSet()
    }

    private fun parseFlag(indicator: String, arguments: Set<String>) =
        Flag(indicator, indicator in arguments)
}

