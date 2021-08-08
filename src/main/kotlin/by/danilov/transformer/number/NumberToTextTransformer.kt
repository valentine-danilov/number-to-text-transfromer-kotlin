package by.danilov.transformer.number

import by.danilov.transformer.number.api.NumberTransformer
import by.danilov.transformer.number.api.NumberTranslator
import org.springframework.stereotype.Service
import java.math.BigInteger
import java.util.*

@Service
class NumberToTextTransformer(private val numberTranslator: NumberTranslator): NumberTransformer<BigInteger, String> {

    override fun transform(number: BigInteger) = transform(number, Locale.ENGLISH)

    fun transform(number: BigInteger, locale: Locale = Locale.ENGLISH): String {
        return buildString {
            var currentNumber: BigInteger? = number
            while (currentNumber != null) {
                val (currentDegreeValue, currentDegreeLength) = getHighestDegreeAndLength(currentNumber)
                val remainingPart = currentNumber.toString().substring(currentDegreeLength)
                val degreeSize = remainingPart.length
                currentNumber = if (remainingPart.length < 3) {
                    if (number == BigInteger.ZERO || currentDegreeValue != 0) append(numberTranslator.getDegreeAsWords(currentDegreeValue, degreeSize, locale))
                    null
                } else {
                    append("${numberTranslator.getDegreeAsWords(currentDegreeValue, degreeSize, locale)} ${numberTranslator.getDegreeName(currentDegreeValue, remainingPart.length, locale)} ")
                    remainingPart.toBigInteger()
                }
            }
        }.trim()
    }

    private fun getHighestDegreeAndLength(number: BigInteger): Pair<Int, Int> {
        val stringNumber = number.toString()
        val degreeLength = stringNumber.length
        val highestDegreeDigitsNumber = if (degreeLength % 3 == 0) 3 else degreeLength % 3
        val degree = stringNumber.substring(0 until highestDegreeDigitsNumber).toInt()
        return degree to highestDegreeDigitsNumber
    }
}