package _2022.day3

import _2015.day1.readFileAsLinesUsingBufferedReader
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day3/input.txt")
    val map = file.map { Pair(it.substring(0, it.length / 2), it.substring(it.length / 2, it.length)) }
    val sumOf = map.map { findCommonChar(it) }.sumOf { getScore(it) }
    println(sumOf)
}

fun findCommonChar(pair: Pair<String, String>): Char {
    val filter = pair.first.toCharArray().filter { pair.second.contains(it) }
    return filter.first()
}

fun getScore(char: Char): Int {
    return when {
        char.isLowerCase() -> char.code - 96
        else -> char.code - 38
    }
}