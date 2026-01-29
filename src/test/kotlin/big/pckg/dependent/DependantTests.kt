package big.pckg.dependent

import com.jetbrains.converters.big.pckg.a.really.looong.naaaaame.fooooor.teeeests.FahrenheitToCelsiusConverter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.Assumptions.assumeTrue

/**
 * Multiple tests, each depends on the previous.
 * In JUnit 5, we use @Order annotation and track state to simulate test dependencies.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class DependantTests {

    companion object {
        private var test1Passed = false
        private var test2Passed = false
        private var test3Passed = false
        private var test4Passed = false
    }

    @Test
    @Order(1)
    fun testFahrenheitToCelsiusConversion_32F_to_0C() {
        val result = FahrenheitToCelsiusConverter.convert(32.0)
        assertEquals(0.0, result, 0.001, "Conversion from 32F to 0C is incorrect")
        test1Passed = true
    }

    @Test
    @Order(2)
    fun testFahrenheitToCelsiusConversion_212F_to_100C() {
        assumeTrue(test1Passed, "Previous test must pass first")
        val result = FahrenheitToCelsiusConverter.convert(212.0)
        assertEquals(100.0, result, 0.001, "Conversion from 212F to 100C is incorrect")
        test2Passed = true
    }

    @Test
    @Order(3)
    fun testFahrenheitToCelsiusConversion_negative_40F_to_negative_40C() {
        assumeTrue(test2Passed, "Previous test must pass first")
        val result = FahrenheitToCelsiusConverter.convert(-40.0)
        assertEquals(-40.0, result, 0.001, "Conversion from -40F to -40C is incorrect")
        test3Passed = true
    }

    @Test
    @Order(4)
    fun failingTest() {
        assumeTrue(test3Passed, "Previous test must pass first")
        val result = FahrenheitToCelsiusConverter.convert(98.6)
        assertEquals(-1111111111.0, result, 0.001, "The test that should fail.")
        test4Passed = true
    }

    @Test
    @Order(5)
    fun `this is the last test that should not execute at all`() {
        assumeTrue(test4Passed, "Previous test must pass first")
        val result = FahrenheitToCelsiusConverter.convert(-1111.0)
        assertEquals(-1111.0, result, 0.001, "Conversion from -1111F to -1111C is incorrect")
    }
}
