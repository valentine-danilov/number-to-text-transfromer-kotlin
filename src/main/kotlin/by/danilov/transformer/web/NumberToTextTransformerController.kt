package by.danilov.transformer.web

import by.danilov.transformer.number.NumberToTextTransformer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/v1/transformer")
class NumberToTextTransformerController(val numberToTextTransformerService: NumberToTextTransformerService) {

    @GetMapping("/transform")
    fun transform(
        @RequestParam("number") number: String,
        @RequestParam("locale") locale: String
    ): ResponseEntity<TransformerResponse> {
        val result = numberToTextTransformerService.transform(
            number = number,
            locale = locale
        )
        return responseSuccess(result, locale)
    }

}