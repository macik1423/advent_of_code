package day3

import _2023.day1.readFileAsLinesUsingBufferedReader
import java.lang.Exception
import java.util.*

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2023/day3/input.txt")
    val rows = file.size
    val columns = file[0].length
    val array = Array(rows) { i -> CharArray(columns) { j -> file[i][j] } }
    val result = mutableListOf<Int>()
    for (i in array.indices) {
        for (j in array[i].indices) {
            if (array[i][j] == '*') {
                val adjacentNumbers = getAdjacentNumbers(i, j, array)
                if (adjacentNumbers.size == 2) {
                    result.add(adjacentNumbers[0] * adjacentNumbers[1])
                }
            }
        }
    }
    print(result.sum())
}

fun getAdjacentNumbers(i: Int, j: Int, array: Array<CharArray>): List<Int> {
    val result = mutableListOf<Int>()
    val ms = listOf(-1, 0, 1)
    val ns = listOf(-1, 0, 1)
    for (m in ms) {
        for (n in ns) {
            try {
                val ii = i + m
                val jj = j + n
                val c = array[ii][jj]
                if (Regex("\\d").matches(c.toString())) {
                    val number = getNumber(ii, jj, array)
                    if (!result.contains(number)) result.add(number)
                }
            } catch (_: Exception) {

            }
        }
    }
    return result
}

fun getNumber(i: Int, j: Int, array: Array<CharArray>): Int {
    val number = goLeft(i, j, array) + goRight(i, j, array)
    return number.toInt()
}

fun goLeft(i: Int, j: Int, array: Array<CharArray>): String {
    val m = i
    var n = j
    var c = array[m][n]
    val number = LinkedList<String>()
    while(Regex("\\d").matches(c.toString()) && n >= 0) {
        number.push(c.toString())
        n--
        if (n >= 0) {
            c = array[m][n]
        }
    }
    return number.joinToString (separator = "")
}

fun goRight(i: Int, j: Int, array: Array<CharArray>): String {
    val m = i
    var n = j + 1
    var c = array[m][n]
    val number = LinkedList<String>()
    while(Regex("\\d").matches(c.toString()) && n < array.size) {
        number.add(c.toString())
        n++
        if (n < array.size) {
            c = array[m][n]
        }
    }
    return number.joinToString (separator = "")
}