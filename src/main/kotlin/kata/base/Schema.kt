package kata.base

data class Schema(val flags: Set<Flag<*>>) {
    constructor(vararg flags: Flag<*>) : this(flags.toSet())

    infix fun matches(arguments: Set<String>) = flags.map(Flag<*>::indicator).containsAll(arguments)
}
