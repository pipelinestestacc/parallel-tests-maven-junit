package com.jetbrains.converters.big.pckg.a.really.looong.naaaaame.fooooor.teeeests

/**
 * A simple object that converts F to C.
 * Package name, along with the structure of the project, is highly simple and used only for testing.
 */
object FahrenheitToCelsiusConverter {
    fun convert(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }
}
