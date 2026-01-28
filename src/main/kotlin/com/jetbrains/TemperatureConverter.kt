package com.jetbrains

import com.jetbrains.converters.big.pckg.a.really.looong.naaaaame.fooooor.teeeests.FahrenheitToCelsiusConverter
import com.jetbrains.converters.regular.pckg.name.CelsiusToFahrenheitConverter
import java.util.*

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Usage: TemperatureConverter <value> <unit>")
        return
    }

    val value = args[0].toDoubleOrNull()
    val unit = args[1].uppercase(Locale.getDefault())

    if (value == null || (unit != "C" && unit != "F")) {
        println("Invalid input! Please provide a valid temperature value followed by unit (C/F).")
        return
    }

    when (unit) {
        "C" -> {
            val fahrenheit = CelsiusToFahrenheitConverter.convert(value)
            println("$value Celsius is equal to $fahrenheit Fahrenheit")
        }
        "F" -> {
            val celsius = FahrenheitToCelsiusConverter.convert(value)
            println("$value Fahrenheit is equal to $celsius Celsius")
        }
    }
}
