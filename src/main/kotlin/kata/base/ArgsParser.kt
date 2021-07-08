package kata.base

class ArgsParser {
    infix fun parse(arguments: Set<String>): Boolean {
        return arguments.isNotEmpty()
    }
}
