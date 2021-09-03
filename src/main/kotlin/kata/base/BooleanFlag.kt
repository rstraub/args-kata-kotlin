package kata.base

class BooleanFlag(indicator: String, val value: Boolean = false) : Flag(indicator) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BooleanFlag

        if (indicator != other.indicator) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = "BooleanFlag(indicator=$indicator, value=$value)"
}
