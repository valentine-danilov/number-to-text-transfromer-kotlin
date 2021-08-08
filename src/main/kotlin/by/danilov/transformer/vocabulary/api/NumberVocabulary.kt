package by.danilov.transformer.vocabulary.api

import by.danilov.transformer.vocabulary.Sex
import java.util.*

interface NumberVocabulary {
    val digitsVocabulary: Map<Int, String>
    val tensVocabulary: Map<Int, String>
    val hundredsVocabulary: Map<Int, String>
    val degreeVocabulary: Map<Int, List<Pair<IntRange, String>>>
    val degreeSexVocabulary: Map<Int, Sex>
    val digitSexVocabulary: Map<Int, Map<Sex, String>>
    fun getSupportedLocale(): Locale
}