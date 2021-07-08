package kata.base

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class ArgsParserTest {
    @Test
    fun `should parse false given a unspecified boolean flag`() {
        val result = ArgsParser() parse emptySet()

        assertFalse(result)
    }
}
