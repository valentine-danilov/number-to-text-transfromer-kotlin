package by.danilov.transformer.vocabulary

import by.danilov.transformer.vocabulary.api.NumberVocabulary
import org.springframework.stereotype.Component
import java.util.*

@Component
class EnglishVocabulary: NumberVocabulary {

    override val degreeVocabulary: MutableMap<Int, List<Pair<IntRange, String>>> = mutableMapOf(
        3 to listOf(
            0..0 to "thousands",
            1..1 to "thousand",
            2..9 to "thousands"
        ),
        6 to listOf(
            0..0 to "millions",
            1..1 to "million",
            2..9 to "millions"
        ),
        9 to listOf(
            0..0 to "billions",
            1..1 to "billion",
            2..9 to "billions"
        )
    )
    override val degreeSexVocabulary: Map<Int, Sex> = mapOf()

    override val digitSexVocabulary: Map<Int, Map<Sex, String>> = mapOf()

    override val digitsVocabulary = mutableMapOf(
        0 to "zero",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine"
    )

    override val tensVocabulary = mutableMapOf(
        10 to "ten",
        11 to  "eleven",
        12 to  "twelve",
        13 to  "thirteen",
        14 to  "fourteen",
        15 to  "fifteen",
        16 to  "sixteen",
        17 to  "seventeen",
        18 to  "eighteen",
        19 to  "nineteen",
        20 to "twenty",
        30 to "thirty",
        40 to "forty",
        50 to "fifty",
        60 to "sixty",
        70 to "seventy",
        80 to "eighty",
        90 to "ninety"
    )

    override val hundredsVocabulary = mutableMapOf(
        100 to "one hundred",
        200 to  "two hundreds",
        300 to  "three hundreds",
        400 to  "four hundreds",
        500 to  "five hundreds",
        600 to  "six hundreds",
        700 to  "seven hundreds",
        800 to  "eight hundreds",
        900 to  "nine hundreds"
    )
    override fun getSupportedLocale(): Locale = Locale.ENGLISH
}