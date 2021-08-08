package by.danilov.transformer.number

import by.danilov.transformer.vocabulary.EnglishVocabulary
import by.danilov.transformer.vocabulary.RussianVocabulary
import by.danilov.transformer.vocabulary.Sex
import by.danilov.transformer.vocabulary.VocabularyResolver
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*


class NumberTranslatorImplTest {

    companion object {
        @JvmStatic
        fun testGetDigitParameters(): List<Arguments> {
            val testCases =
                TestCasesHelper.loadTestCases("src/test/resources/data/transformer/number/number-translator-digits-test-cases.json")
            return testCases.map { Arguments.of(it) }
        }

        @JvmStatic
        fun testGetTensParameters(): List<Arguments> {
            val testCases =
                TestCasesHelper.loadTestCases("src/test/resources/data/transformer/number/number-translator-tens-test-cases.json")
            return testCases.map { Arguments.of(it) }
        }

        @JvmStatic
        fun testGetHundredsParameters(): List<Arguments> {
            val testCases =
                TestCasesHelper.loadTestCases("src/test/resources/data/transformer/number/number-translator-hundreds-test-cases.json")
            return testCases.map { Arguments.of(it) }
        }

        @JvmStatic
        fun testGetDegreeName(): List<Arguments> {
            val testCases =
                TestCasesHelper.loadDegreeTestCases("src/test/resources/data/transformer/number/number-translator-degree-test-cases.json")
            return testCases.map { Arguments.of(it) }
        }
    }


    private val englishVocabulary = EnglishVocabulary()
    private val russianVocabulary = RussianVocabulary()
    private val vocabularyResolver = VocabularyResolver(listOf(englishVocabulary, russianVocabulary))
    private val numberTranslator = NumberTranslatorImpl(vocabularyResolver)

    @ParameterizedTest
    @MethodSource("testGetDigitParameters")
    fun testGetDigitAsWords(testCase: TestCase) {
        val actual = numberTranslator.getDigitAsWord(
            number = testCase.inputNumber.toInt(),
            sex = testCase.sex ?: Sex.MALE,
            locale = Locale(testCase.locale)
        )
        Assertions.assertEquals(testCase.expected, actual)
    }

    @ParameterizedTest
    @MethodSource("testGetTensParameters")
    fun testGetTensAsWords(testCase: TestCase) {
        val actual = numberTranslator.getTensAsWords(
            number = testCase.inputNumber.toInt(),
            sex = testCase.sex ?: Sex.MALE,
            locale = Locale(testCase.locale)
        )
        Assertions.assertEquals(testCase.expected, actual)
    }

    @ParameterizedTest
    @MethodSource("testGetHundredsParameters")
    fun testGetHundredsAsWords(testCase: TestCase) {
        val actual = numberTranslator.getHundredsAsWords(
            number = testCase.inputNumber.toInt(),
            sex = testCase.sex ?: Sex.MALE,
            locale = Locale(testCase.locale)
        )
        Assertions.assertEquals(testCase.expected, actual)
    }

    @ParameterizedTest
    @MethodSource("testGetDegreeName")
    fun testGetDegreeName(testCase: DegreeTestCase) {
        val actual = numberTranslator.getDegreeName(
            degreeAmount = testCase.lastDigit,
            degreeLength = testCase.degreeLength,
            locale = Locale(testCase.locale)
        )
        Assertions.assertEquals(testCase.expected, actual)
    }
}

