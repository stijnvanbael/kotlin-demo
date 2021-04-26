package demo.kotlin

typealias Predicate<V> = (V) -> Boolean
typealias Strings = List<String>

fun main(args: Array<String>) {
    val transformed = transform(listOf("one", "two", "three")) { string -> string.contains('o') }
    println(transformed)
}

fun transform(strings: Strings, predicate: Predicate<String>) =
    strings.filter(predicate).map { string -> string.toUpperCase() }

