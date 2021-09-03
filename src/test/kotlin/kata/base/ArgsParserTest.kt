package kata.base

import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.collections.shouldBeSameSizeAs
import io.kotest.matchers.shouldBe
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
        parser = ArgsParser(Schema(Flag("-l"), Flag("-p")))
    }

    @Test
    fun `should return default value given a unspecified flag`() {
        val result = parser parse emptySet()

        Flag("-l", false) shouldBeIn result
    }

    @Test
    internal fun `should return value given a specified flag`() {
        val result = parser parse setOf("-l")

        Flag("-l", true) shouldBeIn result
    }

    @Test
    internal fun `should parse given multiple specified flags`() {
        val result = parser parse setOf("-l", "-p")

        Flag("-l", true) shouldBeIn result
        Flag("-p", true) shouldBeIn result
    }

    @Test
    internal fun `should return all flags in the schema`() {
        val noArgsResult = parser parse emptySet()
        val oneArgResult = parser parse setOf("-l")

        noArgsResult shouldBeSameSizeAs oneArgResult
    }

    @Test
    internal fun `should throw exception given an unknown specified flag`() {
        assertThrows<IllegalArgumentException> {
            parser parse setOf("-x")
        }
    }
}
