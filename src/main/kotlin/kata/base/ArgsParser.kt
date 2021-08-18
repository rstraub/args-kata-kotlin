package kata.base

class ArgsParser(private val schema: Schema) {

    infix fun parse(arguments: Set<String>): Set<Flag> {
        require(schema matches arguments)
        return schema
            .flagIndicators
            .map { parseFlag(it.indicator, arguments) }
            .toSet()
    }

    private fun parseFlag(indicator: String, arguments: Set<String>) =
        Flag(indicator, indicator in arguments)
}

