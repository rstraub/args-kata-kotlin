package kata.base

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class SchemaTest {
    @Nested
    inner class Matches {
        @Test
        fun `should return true if the arguments match the defined schema`() {
            Schema(setOf(Flag("-l"))) matches setOf("-l") shouldBe true
        }

        @Test
        fun `should return false if the arguments do not match the defined schema`() {
            Schema(setOf(Flag("-l"))) matches setOf("-p") shouldBe false
        }

        @Test
        internal fun `should return true given no arguments`() {
            Schema(setOf(Flag("-l"))) matches emptySet() shouldBe true
        }
    }
}
