package kata.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.exp

class ArgsParserTest {
    private lateinit var parser: ArgsParser

    @BeforeEach
    internal fun setUp() {
        parser = ArgsParser()
    }

    @Test
    fun `should parse false given a unspecified boolean flag`() {
        val result = parser parse emptySet()

        assertEquals("-l", result.indicator)
        assertFalse(result.value)
    }

    @Test
    internal fun `should parse true given a specified boolean flag`() {
        val result = parser parse setOf("-l")

        assertEquals("-l", result.indicator)
        assertTrue(result.value)
    }

    @Test
    internal fun `should parse to true given multiple specified boolean flags`() {
    }

    @Test
    internal fun `should throw exception given an unknown specified boolean flag`() {
        assertThrows<IllegalArgumentException> {
            parser parse setOf("-x")
        }
    }
}
