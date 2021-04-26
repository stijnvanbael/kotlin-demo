package demo.kotlin

import java.time.LocalDate

fun main(args: Array<String>) {
    var project = Project("Artemis", deadline = LocalDate.parse("2024-05-01"))
    println(project)
    project = project.copy(deadline = LocalDate.parse("2026-05-01"))
    println(project)
}

data class Project(val name: String, val deadline: LocalDate)
