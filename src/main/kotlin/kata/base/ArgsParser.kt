package kata.base

class ArgsParser(private val schema: Schema) {

    infix fun parse(arguments: Set<String>): Set<BooleanFlag> {
        require(schema matches arguments)
        return schema
            .flags
            .map { parseFlag(it.indicator, arguments) }
            .toSet()
    }

    private fun parseFlag(indicator: String, arguments: Set<String>) =
        BooleanFlag(indicator, indicator in arguments)
}

