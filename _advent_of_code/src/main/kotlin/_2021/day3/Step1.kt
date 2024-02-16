package _2021.day3

import _2015.day1.readFileAsLinesUsingBufferedReader


fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2021/day3/input.txt")

    val data = file.map { it -> it.split("").filter { it != "" }.toTypedArray() }.toTypedArray()
    val dataTranspose = transposeMatrix(data)
    val map = dataTranspose.map { it -> it.groupBy { it }
        .maxByOrNull { it.value.size }
        ?.key }
    val epsilon = map.joinToString("") {
        when (it) {
            "0" -> "1"
            else -> "0"
        }
    }
    val gamma = map.joinToString("")
    val gammaInt = gamma.toInt(2)
    val epsilonInt = epsilon.toInt(2)
    val result = gammaInt * epsilonInt
    println(result)
}

fun transposeMatrix(matrix: Array<Array<String>>): Array<Array<String>> {
    val rows = matrix.size
    val columns = matrix[0].size
    val transposedMatrix = Array(columns) { Array(rows) { "" } }

    for (i in 0..<rows) {
        for (j in 0..<columns) {
            transposedMatrix[j][i] = matrix[i][j]
        }
    }

    return transposedMatrix
}
