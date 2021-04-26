package java.demo;

import kotlin.demo._03_NullableKt;
import org.jetbrains.annotations.NotNull;

import static java.demo.Functions.println;

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
