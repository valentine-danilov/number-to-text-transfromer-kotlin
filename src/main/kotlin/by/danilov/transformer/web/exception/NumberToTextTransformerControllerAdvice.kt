package by.danilov.transformer.web.exception

import by.danilov.transformer.vocabulary.exception.UnsupportedLocaleException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class NumberToTextTransformerControllerAdvice {

    @ExceptionHandler(value = [UnsupportedLocaleException::class])
    fun handleUnsupportedLocaleException(exception: UnsupportedLocaleException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(exception.message ?: "Unknown locale", 400))
    }

    @ExceptionHandler(value = [TransformException::class])
    fun handleTransformException(exception: TransformException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(exception.message ?: "Invalid number format", 400))
    }

    @ExceptionHandler(value = [IllegalArgumentException::class])
    fun handleUnsupportedLocaleException(exception: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(exception.message ?: "Illegal argument exception", 400))
    }
}