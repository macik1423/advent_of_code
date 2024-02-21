package _2020.day3

import kotlin.math.ceil

fun main() {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2020/day3/input.txt")

    val data = file.map { it.toCharArray() }.toTypedArray()
    val count = getChars(data).count { it == '#' }
    println(count)

}
private fun getChars(data: Array<CharArray>): MutableList<Char> {
    var j = 0
    val result = mutableListOf<Char>()
    for (i in 1..<data.size) {
        var row = data[i].joinToString("")
        j += 3
        if (j >= data[i].size) {
            val repeat = ceil(j * 1.0 / data[i].size).toInt() + 1
            row = row.repeat(repeat)
        }
        result.add(row[j])
    }
    return result
}