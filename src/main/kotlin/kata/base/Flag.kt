package kata.base

abstract class Flag<T>(val indicator: String, val value: T) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Flag<*>

        if (indicator != other.indicator) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = indicator.hashCode()
        result = 31 * result + (value?.hashCode() ?: 0)
        return result
    }

    override fun toString() =
        "${this::class.simpleName}(indicator='$indicator', value=$value)"
}
