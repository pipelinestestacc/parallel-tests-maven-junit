package big.pckg.purposes.succeeded.looooong.naaaaame

import com.jetbrains.converters.regular.pckg.name.CelsiusToFahrenheitConverter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.random.Random

class CelsiusToFahrenheitTest_200tests {

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
            val testData = mutableListOf<DoubleArray>()

            // Fix seed to have a predictable test name
            val seed = 1L
            val randomGenerator = Random(seed)

            // Add 200 test cases
            for (i in 0 until 200) {
                val celsius = randomGenerator.nextDouble(-273.15, 1000.0)
                val fahrenheit = celsius * 9 / 5 + 32
                testData.add(doubleArrayOf(celsius, fahrenheit))
            }

            return testData.stream()
        }
    }
}
