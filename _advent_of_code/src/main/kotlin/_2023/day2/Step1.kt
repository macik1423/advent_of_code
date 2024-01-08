package day2

import _2023.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/day2/input.txt")
    val splitBy = file.map {it.split(" Game")}
    val replaceBy = splitBy.map { it -> it.map { Regex("Game \\d+: ").replace(it, "")} }
    println("replaceBy: $replaceBy")
    println("filter : ${replaceBy.map { it -> it.filter { isCorrect(it) } }}")
    val map = replaceBy.map { it -> it.filter { isCorrect(it) } }.mapIndexed { index, it -> when {
        it.isNotEmpty() -> index + 1
        else -> {0}
    }  }
    print(map.sum())
}

fun isCorrect(str: String): Boolean {
    val splitBy = str.split("; ")
    val splitBy2 = splitBy.map { it.split(", ") }
    val map = splitBy2.flatten().map {
        when {
            it.split(" ")[1] == "blue" && it.split(" ")[0].toInt() > 14 -> false
            it.split(" ")[1] == "red" && it.split(" ")[0].toInt() > 12 -> false
            it.split(" ")[1] == "green" && it.split(" ")[0].toInt() > 13 -> false
            else -> true
        }
    }.toList()
    return map.all { it }
}