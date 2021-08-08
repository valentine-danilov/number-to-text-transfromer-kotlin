package by.danilov.transformer.web

import by.danilov.transformer.number.NumberToTextTransformer
import by.danilov.transformer.web.exception.TransformException
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.util.*

@Service
class NumberToTextTransformerService(val transformer: NumberToTextTransformer) {

    fun transform(number: String, locale: String): String {
        return try {
            transformer.transform(
                number = number.toBigInteger(),
                locale = Locale(locale)
            )
        } catch (exception: NumberFormatException) {
            throw TransformException("Invalid number: $number")
        }
    }

}