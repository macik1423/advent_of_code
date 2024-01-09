package _2015.day2

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day2/input.txt")
    val map = file.map { it -> it.split("x").map { it.toInt() }}.map {
        ribbonToWrap(it[0], it[1], it[2]) +
        ribbonForTheBow(it[0], it[1], it[2])
    }.reduce { acc, n -> acc + n}
    print(map)
}

private fun ribbonToWrap(l: Int, w: Int, h: Int): Int {
    val sorted = listOf(l, w, h).sorted()
    return sorted[0] * 2 + sorted[1] * 2
}

private fun ribbonForTheBow(l: Int, w: Int, h: Int): Int {
    return  l * w * h
}