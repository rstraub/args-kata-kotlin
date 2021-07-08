package kata.base

class ArgsParser {
    private companion object {
        val FLAG = "-l"
    }

    infix fun parse(arguments: Set<String>): Boolean {
        return FLAG in arguments
    }
}
