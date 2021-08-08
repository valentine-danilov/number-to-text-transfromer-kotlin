package by.danilov.transformer.vocabulary

import by.danilov.transformer.vocabulary.api.NumberVocabulary
import org.springframework.stereotype.Component
import java.util.*

@Component
class RussianVocabulary : NumberVocabulary {
    override val degreeVocabulary: MutableMap<Int, List<Pair<IntRange, String>>> = mutableMapOf(
        3 to listOf(
            0..0 to "тысяч",
            1..1 to "тысяча",
            2..4 to "тысячи",
            5..9 to "тысяч",
            11..11 to "тысяч",
        ),
        6 to listOf(
            0..0 to "миллионов",
            1..1 to "миллион",
            2..4 to "миллиона",
            5..19 to "миллионов",
        ),
        9 to listOf(
            0..0 to "миллиардов",
            1..1 to "миллиард",
            2..4 to "миллиарда",
            5..19 to "миллиардов"
        )
    )

    override val digitsVocabulary = mutableMapOf(
        0 to "ноль",
        1 to "один",
        2 to "два",
        3 to "три",
        4 to "четыре",
        5 to "пять",
        6 to "шесть",
        7 to "семь",
        8 to "восемь",
        9 to "девять",
    )

    override val digitSexVocabulary = mutableMapOf(
        0 to mutableMapOf(),
        1 to mutableMapOf(
            "male".toSex() to "один",
            "female".toSex() to "одна",
            "undefined".toSex() to "одно",
        ),
        2 to mutableMapOf(
            "male".toSex() to "два",
            "female".toSex() to "две",
            "undefined".toSex() to "два",
        ),
        3 to mutableMapOf(
            "male".toSex() to "три",
            "female".toSex() to "три",
            "undefined".toSex() to "три",
        ),
        4 to mutableMapOf(
            "male".toSex() to "четыре",
            "female".toSex() to "четыре",
            "undefined".toSex() to "четыре",
        ),
        5 to mutableMapOf(
            "male".toSex() to "пять",
            "female".toSex() to "пять",
            "undefined".toSex() to "пять",
        ),
        6 to mutableMapOf(
            "male".toSex() to "шесть",
            "female".toSex() to "шесть",
            "undefined".toSex() to "шесть",
        ),
        7 to mutableMapOf(
            "male".toSex() to "семь",
            "female".toSex() to "семь",
            "undefined".toSex() to "семь",
        ),
        8 to mutableMapOf(
            "male".toSex() to "восемь",
            "female".toSex() to "восемь",
            "undefined".toSex() to "восемь",
        ),
        9 to mutableMapOf(
            "male".toSex() to "девять",
            "female".toSex() to "девять",
            "undefined".toSex() to "девять",
        )
    )

    override val degreeSexVocabulary = mutableMapOf(
        3 to Sex.FEMALE,
        6 to Sex.MALE,
        9 to Sex.MALE
    )

    override val tensVocabulary = mutableMapOf(
        10 to "десять",
        11 to "одиннадцать",
        12 to "двенадцать",
        13 to "тринадцать",
        14 to "четырнадцать",
        15 to "пятнадцать",
        16 to "шестнадцать",
        17 to "семнадцать",
        18 to "восемнадцать",
        19 to "девятнадцать",
        20 to "двадцать",
        30 to "тридцать",
        40 to "сорок",
        50 to "пятьдесят",
        60 to "шестьдесят",
        70 to "семьдесят",
        80 to "восемьдесят",
        90 to "девяносто"
    )

    override val hundredsVocabulary = mutableMapOf(
        100 to "сто",
        200 to "двести",
        300 to "отсоси у тракториста",
        400 to "четыреста",
        500 to "пятьсот",
        600 to "шестьсот",
        700 to "семьсот",
        800 to "восемьсот",
        900 to "девятьсот",
    )

    override fun getSupportedLocale() = Locale("ru")
}