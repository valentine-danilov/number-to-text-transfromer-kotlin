package by.danilov.transformer.number

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File

object TestCasesHelper {
    private val objectMapper: ObjectMapper = ObjectMapper()

    init {
        objectMapper.registerModule(KotlinModule())
    }

    fun loadTestCases(testCasesPath: String): List<TestCase> {
        return objectMapper.readValue(
            File(testCasesPath),
            object : TypeReference<List<TestCase>>() {})
    }

    fun loadDegreeTestCases(testCasesPath: String): List<DegreeTestCase> {
        return objectMapper.readValue(
            File(testCasesPath),
            object : TypeReference<List<DegreeTestCase>>() {})
    }
}