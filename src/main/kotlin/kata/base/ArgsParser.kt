package kata.base

class ArgsParser(private val schema: Schema) {
    infix fun parse(arguments: String): Set<Flag<*>> {
        if (arguments.isBlank()) return schema.flags
        return parse(setOf(arguments))
    }

    infix fun parse(arguments: Set<String>): Set<Flag<*>> {
        require(schema matches arguments)
        return schema
            .flags
            .map { parseFlag(it, arguments) }
            .toSet()
    }

    private fun parseFlag(flag: Flag<*>, arguments: Set<String>) =
        when (flag) {
            is BooleanFlag -> BooleanFlag(flag.indicator, flag.indicator in arguments)
            is NumericFlag -> flag
            else -> throw IllegalArgumentException("Unsupported flag type")
        }
}

