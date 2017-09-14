package eu.ccvlab.kotlin.demo

import java.math.BigDecimal


fun main(args: Array<String>) {
    println(Money("EUR", BigDecimal("5.5"))
            + Money("EUR", BigDecimal("10")))

    println(Money("EUR", BigDecimal("5.5"))
            + Money("USD", BigDecimal("10")))
}

class Money(val currency: String, val value: BigDecimal) {

    /** Overrides the + operator between two instances of Money */
    operator fun plus(other: Money): Money {
        if (currency != other.currency)
            throw IllegalArgumentException("Cannot add $other to $this, currency differs")
        return Money(currency, value + other.value)
    }

    override fun toString(): String = "$currency $value"
}