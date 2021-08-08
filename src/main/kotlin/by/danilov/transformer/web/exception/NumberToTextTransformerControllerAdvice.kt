package by.danilov.transformer.web.exception

import by.danilov.transformer.vocabulary.exception.UnsupportedLocaleException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class NumberToTextTransformerControllerAdvice {

    @ExceptionHandler(value = [UnsupportedLocaleException::class])
    fun handleIllegalArgumentException(exception: UnsupportedLocaleException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(exception.message ?: "Unknown locale", 400))
    }

    @ExceptionHandler(value = [TransformException::class])
    fun handleTransformException(exception: TransformException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(exception.message ?: "Invalid number format", 400))
    }
}