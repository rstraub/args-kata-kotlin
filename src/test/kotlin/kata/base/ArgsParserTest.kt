package kata.base

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ArgsParserTest {
    @Test
    fun `should parse false given a unspecified boolean flag`() {
        val result = ArgsParser() parse emptySet()

        assertFalse(result)
    }

    @Test
    internal fun `should parse true given a specified boolean flag`() {
        val result = ArgsParser() parse setOf("-l")

        assertTrue(result)
    }
}
