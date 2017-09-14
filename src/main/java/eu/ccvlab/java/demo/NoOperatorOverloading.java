package eu.ccvlab.java.demo;

import java.math.BigDecimal;

import static eu.ccvlab.java.demo.Functions.println;

public class NoOperatorOverloading {
    public static void main(String args[]) {
        println(new Money("EUR", new BigDecimal("5.5"))
                .add(new Money("EUR", new BigDecimal("10"))));

        println(new Money("EUR", new BigDecimal("5.5"))
                .add(new Money("USD", new BigDecimal("10"))));

        // Kotlin interop
        println(new eu.ccvlab.kotlin.demo.Money("EUR", new BigDecimal("5.5"))
                .plus(new eu.ccvlab.kotlin.demo.Money("EUR", new BigDecimal("10"))));
    }

    static class Money {
        public final String currency;
        public final BigDecimal value;

        public Money(String currency, BigDecimal value) {
            this.currency = currency;
            this.value = value;
        }

        public Money add(Money other) {
            if (!currency.equals(other.currency))
                throw new IllegalArgumentException("Cannot add " + other + " to " + this + ", currency differs");
            return new Money(currency, value.add(other.value));
        }

        @Override
        public String toString() {
            return currency + " " + value;
        }
    }
}
