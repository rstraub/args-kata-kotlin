package kata.base

import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.collections.shouldBeSameSizeAs
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
    fun `should return default value given a unspecified flag`() {
        val result = parser parse ""

        BooleanFlag("-l", false) shouldBeIn result
    }

    @Test
    internal fun `should return value given a specified flag`() {
        val result = parser parse "-l"

        BooleanFlag("-l", true) shouldBeIn result
    }

    @Test
    internal fun `should parse given multiple specified flags`() {
        val result = parser parse "-l -p"

        BooleanFlag("-l", true) shouldBeIn result
        BooleanFlag("-p", true) shouldBeIn result
    }

    @Test
    internal fun `should return all flags in the schema`() {
        val noArgsResult = parser parse ""
        val oneArgResult = parser parse "-l"

        noArgsResult shouldBeSameSizeAs oneArgResult
    }

    @Test
    internal fun `should throw exception given an unknown specified flag`() {
        assertThrows<IllegalArgumentException> {
            parser parse "-x"
        }
    }
}
