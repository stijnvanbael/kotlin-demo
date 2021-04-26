package demo.kotlin

fun main(args: Array<String>) {
    var stringOrInt: Either<String, Int>
    stringOrInt = Left("foobar")
    printValue(stringOrInt);
    stringOrInt = Right(123)
    printValue(stringOrInt)
}

fun printValue(stringOrInt: Either<String, Int>) {
    println(stringOrInt.fold(
            {string -> "It's a string: $string"},
            {int -> "It's an int: $int"}
    ))
}

sealed class Either<L, R> {
    abstract fun <V> fold(ifLeft: (L) -> V, ifRight: (R) -> V): V
}

data class Left<L, R>(val value: L) : Either<L, R>() {
    override fun <V> fold(ifLeft: (L) -> V, ifRight: (R) -> V) = ifLeft(value)
}

data class Right<L, R>(val value: R) : Either<L, R>() {
    override fun <V> fold(ifLeft: (L) -> V, ifRight: (R) -> V) = ifRight(value)
}
