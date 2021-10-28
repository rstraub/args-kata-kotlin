package kata.base

import io.kotest.matchers.collections.shouldBeIn
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ArgsParserTest {
    private lateinit var parser: ArgsParser

    @BeforeEach
    internal fun setUp() {
        parser = ArgsParser(Schema(BooleanFlag("-l"), BooleanFlag("-p")))
    }

    @Test
    fun `should return default values from schema given no arguments are supplied`() {
        val result = parser parse ""

        BooleanFlag("-l", false) shouldBeIn result
    }

    @Test
    internal fun `should return values given some arguments are supplied`() {
        val result = parser parse "-l"

        BooleanFlag("-l", true) shouldBeIn result
    }

    @Test
    internal fun `should return the values given all arguments are supplied`() {
        val result = parser parse "-l -p"

        BooleanFlag("-l", true) shouldBeIn result
        BooleanFlag("-p", true) shouldBeIn result
    }

    @Test
    internal fun `should throw exception given an unknown specified flag`() {
        assertThrows<IllegalArgumentException> {
            parser parse "-x"
        }
    }
}
