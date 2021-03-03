package com.salvaperez.test1.presentation.extensions

import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.roundToInt

fun Double.roundTo(numFractionDigits: Int): String {
    val factor = 10.0.pow(numFractionDigits.toDouble())
    val roundedDecimal = floor(this * factor).roundToInt() / factor
    return "$roundedDecimal €"
}
