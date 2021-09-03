package kata.base

import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import org.junit.jupiter.api.Test

internal class BooleanFlagTest {
    @Test
    internal fun `should be built using custom value`() {
        val result = BooleanFlag("-l", true)

        result.value.shouldBeTrue()
    }

    @Test
    internal fun `should be built using default value`() {
        val result = BooleanFlag("-l")

        result.value.shouldBeFalse()
    }
}
