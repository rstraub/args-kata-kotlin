package kata.base

data class Schema(val flags: Set<BooleanFlag>) {
    constructor(vararg flags: BooleanFlag) : this(flags.toSet())

    infix fun matches(arguments: Set<String>) = flags.map(BooleanFlag::indicator).containsAll(arguments)
}
