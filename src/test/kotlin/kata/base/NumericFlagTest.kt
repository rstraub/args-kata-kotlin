package kata.base

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class NumericFlagTest {
    @Test
    internal fun `should be created given custom value`() {
        val result = NumericFlag("-p", 8080)

        result.value shouldBe 8080
    }

    @Test
    internal fun `should be created given default value`() {
        val result = NumericFlag("-p")

        result.value shouldBe -1
    }
}
