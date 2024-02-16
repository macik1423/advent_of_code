package _2015.day1

import java.io.File

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day1/input.txt")
    val result = file.map { it.toCharArray() }[0].fold(0) { acc, s ->
        when (s) {
            '(' -> acc + 1
            ')' -> acc - 1
            else -> {
                acc
            }
        }
    }
    print(result)
}

fun readFileAsLinesUsingBufferedReader(fileName: String): List<String>
        = File(fileName).bufferedReader().readLines()