package _2015.day2

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day2/input.txt")
    val map = file.map { it -> it.split("x").map { it.toInt() }}.map {
        2 * it[0] * it[1] +
        2 * it[1] * it[2] +
        2 * it[0] * it[2] +
        areaOfTheSmallestSide(it[0], it[1], it[2])
    }.reduce { acc, n -> acc + n}
            print(map)
}

private fun areaOfTheSmallestSide(l: Int, w: Int, h: Int): Int {
    return minOf(l * w, minOf(w * h, l * h))
}