package eu.ccvlab.kotlin.demo

import java.io.PrintWriter
import java.io.StringWriter
import java.time.LocalDateTime


fun main(args: Array<String>) {
    logError()
    logError("Something went wrong, that's all we know")
    logError(throwable = NullPointerException("Something cannot be null"))
    logError(stackTrace = "\tat foo.Bar.baz(Bar.kt:10)", throwable = NullPointerException("Something cannot be null"))
    logError("Unexpected error", stackTrace = "\tat foo.Bar.baz(Bar.kt:10)", throwable = NullPointerException("Something cannot be null"))
}

fun logError(message: String = "Unknown error", throwable: Throwable? = null, stackTrace: String? = stackTraceOf(throwable)) {
    println("${LocalDateTime.now()} ERROR $message" +
            (if (throwable != null) "\n${throwable.javaClass}: ${throwable.message}" else "") +
            (if (stackTrace != null) "\n$stackTrace" else "") +
            "\n")
}

fun stackTraceOf(throwable: Throwable?): String? {
    if (throwable == null) return null
    val writer = StringWriter()
    throwable.printStackTrace(PrintWriter(writer))
    return writer.toString().substringAfter("\n").substringBeforeLast("\n")
}