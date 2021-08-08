package by.danilov.transformer.vocabulary

import by.danilov.transformer.vocabulary.api.NumberVocabulary
import by.danilov.transformer.vocabulary.exception.UnsupportedLocaleException
import org.springframework.stereotype.Component
import java.util.*

@Component
class VocabularyResolver(supportedVocabularies: List<NumberVocabulary>) {

    private val vocabularies: Map<Locale, NumberVocabulary> = supportedVocabularies.associateBy { vocabulary -> vocabulary.getSupportedLocale() }

    fun resolve(locale: Locale) = vocabularies[locale] ?: throw UnsupportedLocaleException("Locale '$locale' is not supported")
}