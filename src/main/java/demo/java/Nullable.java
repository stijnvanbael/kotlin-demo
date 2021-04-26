package demo.java;

import static demo.java.Functions.println;

import demo.kotlin._03_NullableKt;
import org.jetbrains.annotations.NotNull;

public class Nullable {
    @SuppressWarnings("UnusedAssignment")
    public static void main(String[] args) {
        String nullable = "a value";
        @NotNull String notNullable = "a value";

        nullable = null;
        notNullable = null;

        println(nullable);
        println(notNullable);

        // Kotlin interop
        _03_NullableKt.setNotNullable(null);
    }
}
