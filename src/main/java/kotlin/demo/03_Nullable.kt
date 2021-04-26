package kotlin.demo

@Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER", "RedundantExplicitType", "CanBeVal")

var nullable : String? = "a value"
var notNullable : String = "a value"

fun main(args: Array<String>) {
    nullable = null
    // notNullable = null

    println(nullable)
    println(notNullable)
}
