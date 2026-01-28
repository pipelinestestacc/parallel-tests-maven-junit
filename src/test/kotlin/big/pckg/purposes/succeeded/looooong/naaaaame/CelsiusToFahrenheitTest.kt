package big.pckg.purposes.succeeded.looooong.naaaaame

import com.jetbrains.converters.regular.pckg.name.CelsiusToFahrenheitConverter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CelsiusToFahrenheitTest {

    @ParameterizedTest
    @MethodSource("conversionDataCelsiusToFahrenheit")
    fun testCelsiusToFahrenheitConversion(testCase: DoubleArray) {
        val celsius = testCase[0]
        val expectedFahrenheit = testCase[1]
        val result = CelsiusToFahrenheitConverter.convert(celsius)
        assertEquals(expectedFahrenheit, result, 0.001, "Conversion from Celsius to Fahrenheit is incorrect")
    }

    companion object {
        @JvmStatic
        fun conversionDataCelsiusToFahrenheit(): Stream<DoubleArray> {
            return Stream.of(
                doubleArrayOf(0.0, 32.0),
                doubleArrayOf(100.0, 212.0),
                doubleArrayOf(-40.0, -40.0),
                doubleArrayOf(37.0, 98.6),
                doubleArrayOf(-273.15, -459.67)
            )
        }
    }
}
