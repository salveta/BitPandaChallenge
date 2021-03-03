package com.salvaperez.test1

import com.salvaperez.test1.presentation.extensions.roundTo
import org.assertj.core.api.Assertions
import org.junit.Test

class PrecisionTest {

    @Test
    fun `check precision with two decimal`() {
        val roundedPrice = "0.23 €"
        val price = 0.23489897
        val value = price.roundTo(2)
        Assertions.assertThat(value).isEqualTo(roundedPrice)
    }

    @Test
    fun `check precision with three decimal`() {
        val roundedPrice = "0.234 €"
        val price = 0.23489897
        val value = price.roundTo(3)
        Assertions.assertThat(value).isEqualTo(roundedPrice)
    }

    @Test
    fun `check precision with four decimal`() {
        val roundedPrice = "0.2348 €"
        val price = 0.23489897
        val value = price.roundTo(4)
        Assertions.assertThat(value).isEqualTo(roundedPrice)
    }
}