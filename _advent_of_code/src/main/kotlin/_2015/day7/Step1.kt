package _2015.day7

import _2015.day1.readFileAsLinesUsingBufferedReader
enum class Operations {
    AND, OR, LSHIFT, RSHIFT, NOT
}
data class Command(val number: Int?, val variable1: String?, val variable2: String?, val operation: Operations?, val destinationVariable: String)
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day7/input.txt")
    val data = file.map {
        when {
            it.contains("AND") -> Command(
                number = null,
                operation = Operations.AND,
                variable1 = getV1(it, "AND"),
                variable2 = getV2(it, "AND"),
                destinationVariable = getDV(it)
            )
            it.contains("OR") -> Command(
                number = null,
                operation = Operations.OR,
                variable1 = getV1(it, "OR"),
                variable2 = getV2(it, "OR"),
                destinationVariable = getDV(it)
            )
            it.contains("LSHIFT") -> Command(
                number = null,
                operation = Operations.LSHIFT,
                variable1 = getV1(it, "LSHIFT"),
                variable2 = getV2(it, "LSHIFT"),
                destinationVariable = getDV(it)
            )
            it.contains("RSHIFT") -> Command(
                number = null,
                operation = Operations.RSHIFT,
                variable1 = getV1(it, "RSHIFT"),
                variable2 = getV2(it, "RSHIFT"),
                destinationVariable = getDV(it)
            )
            it.contains("NOT") -> Command(
                number = null,
                operation = Operations.NOT,
                variable1 = null,
                variable2 = getV2(it, "NOT"),
                destinationVariable = getDV(it)
            )
            else -> Command(
                number = it.split("->")[0].trim().toInt()
                , null, null, null,
                destinationVariable = it.split("->")[1].trim()
            )
        }
    }
    println(data)
}


private fun getDV(it: String) = it.split("->")[1].trim()

private fun getV2(it: String, operation: String) = it.split(operation)[1].split("->")[0].trim()

private fun getV1(it: String, operation: String) = it.split(operation)[0].trim()
