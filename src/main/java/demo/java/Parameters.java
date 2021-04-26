package demo.java;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

import static demo.java.Functions.println;

import demo.kotlin._05_ParametersKt;

public class Parameters {
    public static void main(String[] args) {
        logError();
        logError("Something went wrong, that's all we know");
        logError(new NullPointerException("Something cannot be null"));
        logError(new NullPointerException("Something cannot be null"), "\tat foo.Bar.baz(Bar.java:10)");
        logError("Unexpected error", new NullPointerException("Something cannot be null"), "\tat foo.Bar.baz(Bar.java:10)");

        // Kotlin interop
        _05_ParametersKt.logError("Unexpected error", new NullPointerException("Something cannot be null"), "\tat foo.Bar.baz(Bar.java:10)");
    }

    private static void logError() {
        logError("Unknown error");
    }

    private static void logError(String message) {
        logError(message, null, null);
    }

    private static void logError(Throwable throwable) {
        logError("Unknown error", throwable, stackTraceOf(throwable));
    }

    private static void logError(Throwable throwable, String stackTrace) {
        logError("Unknown error", throwable, stackTrace);
    }

    private static void logError(String message, Throwable throwable, String stackTrace) {
        println(LocalDateTime.now() + " ERROR " + message +
                (throwable != null ? "\n" + throwable.getClass() + ": " + throwable.getMessage() : "") +
                (stackTrace != null ? "\n" + stackTrace : "") +
                "\n");
    }

    private static String stackTraceOf(Throwable throwable) {
        if (throwable == null) return null;
        StringWriter writer = new StringWriter();
        throwable.printStackTrace(new PrintWriter(writer));
        String stackTrace = writer.toString();
        return stackTrace.substring(stackTrace.indexOf("\n") + 1, stackTrace.lastIndexOf("\n"));
    }
}
