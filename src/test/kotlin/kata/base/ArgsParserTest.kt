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
        val expected = Flag("-l", false)
        val result = parser parse emptySet()

        assertEquals(expected, result)
    }

    @Test
    internal fun `should parse true given a specified boolean flag`() {
        val expected = Flag("-l", true)
        val result = parser parse setOf("-l")

        assertEquals(expected, result)
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
