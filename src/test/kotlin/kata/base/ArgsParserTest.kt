package kata.base

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ArgsParserTest {
    private lateinit var parser: ArgsParser

    @Nested
    inner class ArgumentsAndDefaults {
        @BeforeEach
        internal fun setUp() {
            parser = ArgsParser(Schema(BooleanFlag("-l"), BooleanFlag("-p")))
        }

        @Test
        fun `should return default values from schema given no arguments are supplied`() {
            val result = parser parse ""

            result shouldBe setOf(
                BooleanFlag("-l", false),
                BooleanFlag("-p", false)
            )
        }

        @Test
        internal fun `should return values given some arguments are supplied`() {
            val result = parser parse "-l"

            result shouldBe setOf(
                BooleanFlag("-l", true),
                BooleanFlag("-p", false)
            )
        }

        @Test
        internal fun `should return the values given all arguments are supplied`() {
            val result = parser parse "-l -p"

            result shouldBe setOf(
                BooleanFlag("-l", true),
                BooleanFlag("-p", true)
            )
        }
    }

    @Nested
    inner class NumericFlags {
        @BeforeEach
        fun setup() {
            parser = ArgsParser(Schema(NumericFlag("-p", 8080)))
        }

        @Test
        fun `should return default values from schema given no arguments are supplied`() {
            val result = parser parse ""

            result shouldBe setOf(
                NumericFlag("-p", 8080),
            )
        }
    }

    @Test
    internal fun `should throw exception given an unknown specified flag`() {
        parser = ArgsParser(Schema())

        assertThrows<IllegalArgumentException> {
            parser parse "-x"
        }
    }
}
