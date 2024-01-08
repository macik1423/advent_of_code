package _2023.day1

import java.io.File

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2023/day1/input.txt")
    val digits = file.map { it -> it.toCharArray().filter { it.isDigit() } }
    val pairsOfDigits = digits.map {
        if (it.size == 1) {
            listOf(it.first(), it.first())
        } else {
            listOf(it.first(), it.last())
        }
    }
    val numbers = pairsOfDigits.map { "${it.first()}${it.last()}" }.map { it.toInt() }
    val sum = numbers.sum()
    print(sum)
}

fun readFileAsLinesUsingBufferedReader(fileName: String): List<String>
        = File(fileName).bufferedReader().readLines()