package by.danilov.transformer.vocabulary

import by.danilov.transformer.number.throwError

fun String.toSex() = Sex.of(this)

enum class Sex(var value: String) {
    MALE("male"),
    FEMALE("female"),
    UNDEFINED("undefined");

    companion object {
        fun of(stringValue: String): Sex {
            return values().find { it.value == stringValue } ?: throwError("Unsupported value '$stringValue'")
        }
    }
}