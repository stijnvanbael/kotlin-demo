package demo.kotlin

fun main(args: Array<String>) {
    val range = Range.between(1, 10)
    println(range)
}

data class Range<T>(val start: T, val end: T) {
    companion object {
        @JvmStatic // allows Java interop
        fun <T> between(start: T, end: T) = Range(start, end)
    }
}
