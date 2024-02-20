package _2016.day3

import _2017.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2016/day3/input.txt")
    val data = file.map { it.replace("\\s+".toRegex(), " ").trim().split(" ").toTypedArray() }.toTypedArray()
    val transposedData =
        transposeMatrix(data)
            .withIndex()
            .groupBy { it.index / 3 }
            .map { it -> it.value.map { it.value } }
            .map { Triple(it[0].toInt(), it[1].toInt(), it[2].toInt())}

    val count = transposedData.count {
        it.first + it.second > it.third &&
        it.third + it.second > it.first &&
        it.first + it.third > it.second
    }
    println(count)
}

private fun transposeMatrix(matrix: Array<Array<String>>): List<String> {
    val rows = matrix.size
    val columns = matrix[0].size
    val transposedMatrix = Array(columns) { Array(rows) { "" } }

    for (i in 0..<rows) {
        for (j in 0..<columns) {
            transposedMatrix[j][i] = matrix[i][j]
        }
    }

    return transposedMatrix.flatten()
}