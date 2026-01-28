package com.jetbrains.converters.regular.pckg.name

/**
 * A simple object that converts C to F.
 * Package name, along with the structure of the project, is highly simple and used only for testing.
 */
object CelsiusToFahrenheitConverter {
    fun convert(celsius: Double): Double {
        return celsius * 9 / 5 + 32
    }
}
