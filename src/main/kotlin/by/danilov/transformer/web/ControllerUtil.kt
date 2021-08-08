package by.danilov.transformer.web

import org.springframework.http.ResponseEntity

fun responseSuccess(result: String, locale: String) = ResponseEntity.ok(TransformerResponse(result, locale))