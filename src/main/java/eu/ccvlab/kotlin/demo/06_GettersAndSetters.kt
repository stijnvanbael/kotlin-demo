package eu.ccvlab.kotlin.demo

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

fun main(args: Array<String>) {
    val person = Person(LocalDate.parse("1980-06-15"))

    println(person.dateOfBirthAsIso8601)
    println(person.dateOfBirthAsMillis)

    person.dateOfBirthAsIso8601 = "1981-06-15"

    println(person.dateOfBirthAsIso8601)
    println(person.dateOfBirthAsMillis)
}

class Person(var dateOfBirth: LocalDate) {
    var dateOfBirthAsIso8601: String
        get() = dateOfBirth.toString()
        set(value) {
            dateOfBirth = LocalDate.parse(value)
        }

    var dateOfBirthAsMillis: Long
        get() = dateOfBirth.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000
        set(value) {
            dateOfBirth = LocalDateTime.ofEpochSecond(value / 1000, 0, ZoneOffset.UTC).toLocalDate()
        }
}