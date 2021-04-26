package kotlin.demo

fun main(args: Array<String>) {
    val list = listOf("first", "second", "third")
    println(list.middle())
}

/** Adds middle() function to all instances of List */
fun <T> List<T>.middle(): T? {
    if (this.isEmpty()) return null
    val middlePos = Math.ceil(this.size.toDouble() / 2).toInt() - 1
    return this[middlePos]
}
