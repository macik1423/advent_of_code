package day4

import _2023.day1.readFileAsLinesUsingBufferedReader
import kotlin.math.pow

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/day4/input.txt")
    val splitBy = file.map { Regex("Card\\s+\\d+: ").replace(it, "") }
    val splitBy2 = splitBy.map { it.split("|")}
    val splitBy3 = splitBy2.map { it -> it.map {it.split(" ")} }
    val numbers = splitBy3.map { it -> it.map { it -> it.filter { it.isNotEmpty() }.map { it.toInt() } }}
    val result = numbers.map { countPoints(it) }
    val sum = result.sum()
    print(sum)
}

fun countPoints(list: List<List<Int>>): Int {
    val winnerList = list[0]
    val numbersList = list[1]

    val count = numbersList.count { winnerList.contains(it) }

    return 2.0.pow(count - 1.0).toInt()
}