package day2

import day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/day2/input.txt")
    val splitBy = file.map {it.split(" Game")}
    val replaceBy = splitBy.map { it -> it.map { Regex("Game \\d+: ").replace(it, "")} }
    val map = replaceBy.flatMap { it -> it.map { getMax(it) } }
    print(map.sum())
}

fun getMax(str: String): Int {
    val splitBy = str.split("; ")
    val splitBy2 = splitBy.flatMap { it.split(", ") }
    val maxBlue = splitBy2.maxBy {
        when {
            it.split(" ")[1] == "blue" -> it.split(" ")[0].toInt()
            else -> {
                0
            }
        }
    }.split(" ")[0].toInt()
    val maxRed = splitBy2.maxBy {
        when {
            it.split(" ")[1] == "red" -> it.split(" ")[0].toInt()
            else -> {
                0
            }
        }
    }.split(" ")[0].toInt()
    val maxGreen = splitBy2.maxBy {
        when {
            it.split(" ")[1] == "green" -> it.split(" ")[0].toInt()
            else -> {
                0
            }
        }
    }.split(" ")[0].toInt()
    return maxBlue * maxRed * maxGreen
}