package by.danilov.transformer.number.api

import by.danilov.transformer.vocabulary.Sex
import java.util.*

interface NumberTranslator {
    fun getDigitAsWord(number: Int, sex: Sex = Sex.MALE, locale: Locale = Locale.ENGLISH): String
    fun getTensAsWords(number: Int, sex: Sex = Sex.MALE, locale: Locale = Locale.ENGLISH): String
    fun getHundredsAsWords(number: Int, sex: Sex = Sex.MALE , locale: Locale = Locale.ENGLISH): String
    fun getDegreeAsWords(number: Int, degreeLength: Int, locale: Locale = Locale.ENGLISH): String
    fun getDegreeName(degreeAmount: Int, degreeLength: Int, locale: Locale = Locale.ENGLISH): String
}