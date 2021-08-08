package by.danilov.transformer.number.api

interface NumberTransformer<N: Number, R> {
    fun transform(number: N): R
}