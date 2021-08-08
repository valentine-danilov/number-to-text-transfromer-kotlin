package by.danilov.transformer.number

import by.danilov.transformer.vocabulary.EnglishVocabulary
import by.danilov.transformer.vocabulary.RussianVocabulary
import by.danilov.transformer.vocabulary.VocabularyResolver
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class NumberToTextTransformerTest {

    companion object {
        @JvmStatic
        fun testTransformParameters(): List<Arguments> {
            val testCases =
                TestCasesHelper.loadTestCases("src/test/resources/data/transformer/number/number-transformer-test-cases.json")
            return testCases.map { Arguments.of(it) }
        }
    }

    private val englishVocabulary = EnglishVocabulary()
    private val russianVocabulary = RussianVocabulary()
    private val vocabularyResolver = VocabularyResolver(listOf(englishVocabulary, russianVocabulary))
    private val numberTranslator = NumberTranslatorImpl(vocabularyResolver)
    private val numberTransformer = NumberToTextTransformer(numberTranslator)

    @ParameterizedTest
    @MethodSource("testTransformParameters")
    fun testTransform(testCase: TestCase) {
        val actual = numberTransformer.transform(
            number = testCase.inputNumber,
            locale = Locale(testCase.locale)
        )
        Assertions.assertEquals(testCase.expected, actual)
    }

}