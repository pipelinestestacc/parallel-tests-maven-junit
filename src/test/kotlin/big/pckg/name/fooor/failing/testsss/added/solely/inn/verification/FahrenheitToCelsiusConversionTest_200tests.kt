package big.pckg.name.fooor.failing.testsss.added.solely.inn.verification

import com.jetbrains.converters.big.pckg.a.really.looong.naaaaame.fooooor.teeeests.FahrenheitToCelsiusConverter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FahrenheitToCelsiusConversionTest_200tests {

    @ParameterizedTest
    @MethodSource("conversionDataFahrenheitToCelsius")
    fun testFahrenheitToCelsiusConversion(testCase: DoubleArray) {
        val fahrenheit = testCase[0]
        val expectedCelsius = testCase[1]
        val result = FahrenheitToCelsiusConverter.convert(fahrenheit)
        assertEquals(expectedCelsius, result, 0.001, "Conversion from Fahrenheit to Celsius is incorrect")
    }

    companion object {
        @JvmStatic
        fun conversionDataFahrenheitToCelsius(): Stream<DoubleArray> {
            val testData = mutableListOf<DoubleArray>()

            // Add 200 test cases
            for (i in 0 until 200) {
                val fahrenheit = i * 10.0
                val celsius = (fahrenheit - 32) * 5 / 9
                testData.add(doubleArrayOf(fahrenheit, celsius))
            }

            return testData.stream()
        }
    }
}
