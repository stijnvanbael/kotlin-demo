package demo.kotlin

import kotlin.math.pow

fun main(args: Array<String>) {
    showArea(Circle(5.0))
    val rectangle = Rectangle(3.0, 4.0)
    showArea(rectangle)
    showArea(rectangle.copy(width = 7.0))
}

fun showArea(shape: Shape) {
    when(shape) {
        is Circle -> println("Circle with radius ${shape.radius}, area: ${shape.area}")
        is Rectangle -> println("Rectangle with width ${shape.width}, height: ${shape.height}, area: ${shape.area}")
    }
}

interface Shape {
    val area: Double
}

data class Circle(val radius: Double) : Shape {
    override val area: Double
        get() = Math.PI * radius.pow(2)
}

data class Rectangle(val width: Double, val height: Double) : Shape {
    override val area: Double
        get() = width * height
}
