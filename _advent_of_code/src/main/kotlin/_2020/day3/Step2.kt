package _2020.day3

import kotlin.math.ceil

fun main() {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2020/day3/input.txt")

    val data = file.map { it.toCharArray() }.toTypedArray()
    val parameters = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
    val result =
        parameters.map { it -> getChars(data, it.first, it.second).count { it == '#' } }.fold(1L) { a, b -> a * b }
    println(result)

}

private fun getChars(data: Array<CharArray>, right: Int, down: Int): MutableList<Char> {
    var j = 0
    val result = mutableListOf<Char>()
    for (i in down..<data.size step down) {
        var row = data[i].joinToString("")
        j += right
        if (j >= data[i].size) {
            val repeat = ceil(j * 1.0 / data[i].size).toInt() + 1
            row = row.repeat(repeat)
        }
        result.add(row[j])
    }
    return result
}