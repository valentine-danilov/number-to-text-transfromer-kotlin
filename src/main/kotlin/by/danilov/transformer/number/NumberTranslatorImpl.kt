package by.danilov.transformer.number

import by.danilov.transformer.number.api.NumberTranslator
import by.danilov.transformer.vocabulary.Sex
import by.danilov.transformer.vocabulary.VocabularyResolver
import by.danilov.transformer.vocabulary.api.NumberVocabulary
import org.springframework.stereotype.Component
import java.util.*

@Component
class NumberTranslatorImpl(private val vocabularyResolver: VocabularyResolver) : NumberTranslator {

    override fun getDigitAsWord(number: Int, sex: Sex, locale: Locale): String {
        val vocabulary = vocabularyResolver.resolve(locale)
        val digitSexes = vocabulary.digitSexVocabulary[number] ?: mapOf()
        return digitSexes[sex] ?: vocabulary.digitsVocabulary[number] ?: throwError("Digit must be in 0..9 range")
    }

    override fun getTensAsWords(number: Int, sex: Sex, locale: Locale): String {
        val vocabulary = vocabularyResolver.resolve(locale)
        if (number < 10 || number > 99) throwError("Tens must be in 10..99")
        return if (number < 21) {
            return vocabulary.tensVocabulary[number]!!
        } else {
            val tensDegree = vocabulary.tensVocabulary[number - number % 10]!!
            val onesDegree = if (number % 10 == 0) "" else getDigitAsWord(number % 10, sex, locale)
            "$tensDegree${if (onesDegree.isEmpty()) "" else " $onesDegree"}"
        }
    }

    override fun getHundredsAsWords(number: Int, sex: Sex, locale: Locale): String {
        val vocabulary = vocabularyResolver.resolve(locale)
        if (number < 100 || number > 999) throwError("Hundreds must be in 100..999")
        val lastDigits = number.toString().substring(1..2).toInt()
        val hundreds = vocabulary.hundredsVocabulary[number - number % 100]!!
        val tens = when (lastDigits) {
            0 -> ""
            in 1..9 -> getDigitAsWord(lastDigits, sex, locale)
            in 10..99 -> getTensAsWords(lastDigits, sex, locale)
            else -> "Hello there" // Won't be executed
        }
        return "$hundreds${if (tens.isNotEmpty()) " $tens" else ""}";
    }

    override fun getDegreeAsWords(number: Int, degreeLength: Int, locale: Locale): String {
        val vocabulary = vocabularyResolver.resolve(locale)
        val degreeSex = if (degreeLength < 3) {
            Sex.MALE
        } else {
            vocabulary.degreeSexVocabulary[degreeLength] ?: Sex.MALE
        }
        return when (number) {
            in 0..9 -> getDigitAsWord(number, degreeSex, locale)
            in 10..99 -> getTensAsWords(number, degreeSex, locale)
            in 100..999 -> getHundredsAsWords(number, degreeSex, locale)
            else -> throwError("Degree must be in 0..999 range")
        }
    }

    override fun getDegreeName(degreeAmount: Int, degreeLength: Int, locale: Locale): String {
        val vocabulary = vocabularyResolver.resolve(locale)
        val lastDigit = degreeAmount % 10
        val lastTen = degreeAmount % 100

        return getDegreeForDegreeAmount(lastTen, degreeLength, vocabulary)
            ?: getDegreeForDegreeAmount(lastDigit, degreeLength, vocabulary)
            ?: throwError("Unsupported degree length or invalid first digit")
    }

    private val getDegreeForDegreeAmount: (Int, Int, NumberVocabulary) -> String? = { amount, length, vocabulary ->
        vocabulary.degreeVocabulary[length]
            ?.firstOrNull { (range, _) -> amount in range }
            ?.second
    }
}