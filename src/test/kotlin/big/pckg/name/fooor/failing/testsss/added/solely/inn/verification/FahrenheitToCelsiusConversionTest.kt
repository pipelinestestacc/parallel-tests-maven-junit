package big.pckg.name.fooor.failing.testsss.added.solely.inn.verification

import com.jetbrains.converters.big.pckg.a.really.looong.naaaaame.fooooor.teeeests.FahrenheitToCelsiusConverter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class FahrenheitToCelsiusConversionTest {

    @ParameterizedTest
    @MethodSource("conversionDataFahrenheitToCelsius")
    @Order(3)
    fun testFahrenheitToCelsiusConversion(testCase: DoubleArray) {
        val fahrenheit = testCase[0]
        val expectedCelsius = testCase[1]
        val result = FahrenheitToCelsiusConverter.convert(fahrenheit)
        assertEquals(expectedCelsius, result, 0.001, "Conversion from Fahrenheit to Celsius is incorrect")
    }

    @Test
    @Order(1)
    fun `first test with higher priority`() {
        val result = FahrenheitToCelsiusConverter.convert(32.0)
        assertEquals(0.0, result, 0.001, "Conversion from Fahrenheit to Celsius is incorrect")
    }

    @Test
    @Order(2)
    fun `second test with higher priority`() {
        val result = FahrenheitToCelsiusConverter.convert(212.0)
        assertEquals(100.0, result, 0.001, "Conversion from Fahrenheit to Celsius is incorrect")
    }

    companion object {
        @JvmStatic
        fun conversionDataFahrenheitToCelsius(): Stream<DoubleArray> {
            return Stream.of(
                doubleArrayOf(32.0, 0.0),
                doubleArrayOf(212.0, 100.0),
                doubleArrayOf(-40.0, -40.0),
                doubleArrayOf(98.6, 37.0),
                // will fail
                doubleArrayOf(-1111.0, -1111.0)
            )
        }
    }
}
