package _2022.day3

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day3/input.txt")
    val zipped = file.withIndex()
        .groupBy { it.index / 3 }
        .map { it -> it.value.map { it.value } }
        .map { Triple(it[0], it[1], it[2])}
    val sumOf = zipped.map { findCommonChar(it) }.sumOf { getScore(it) }
    println(sumOf)
}

fun findCommonChar(triple: Triple<String, String, String>): Char {
    val filter = triple.first.toCharArray().filter { triple.second.contains(it) && triple.third.contains(it) }
    return filter.first()
}