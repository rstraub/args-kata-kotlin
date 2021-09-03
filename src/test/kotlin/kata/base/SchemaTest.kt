package kata.base

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class SchemaTest {
    private val schema = Schema(BooleanFlag("-l"), BooleanFlag("-d"))

    @Nested
    inner class Matches {
        @Test
        internal fun `should return true given an argument defined by the schema`() {
            schema matches setOf("-l") shouldBe true
        }

        @Test
        internal fun `should return true given all arguments defined by the schema`() {
            schema matches setOf("-l", "-d") shouldBe true
        }

        @Test
        internal fun `should return false if the arguments do not match the defined schema`() {
            schema matches setOf("-x") shouldBe false
        }

        @Test
        internal fun `should return true given no arguments`() {
            schema matches emptySet() shouldBe true
        }
    }
}
