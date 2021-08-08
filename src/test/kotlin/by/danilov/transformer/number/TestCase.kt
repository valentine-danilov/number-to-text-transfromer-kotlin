package by.danilov.transformer.number

import by.danilov.transformer.vocabulary.Sex
import java.math.BigInteger

data class TestCase(
    val inputNumber: BigInteger,
    val locale: String,
    val sex: Sex?,
    val expected: String
)

data class DegreeTestCase(
    val lastDigit: Int,
    val degreeLength: Int,
    val locale: String,
    val expected: String
)