package _2021.day2

import _2015.day1.readFileAsLinesUsingBufferedReader
import kotlin.math.abs

data class State(val horizontal: Int = 0, val vertical: Int = 0)

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2021/day2/input.txt")
    val parsed = file.map { Pair(it.split(" ")[0], Integer.parseInt(it.split(" ")[1])) }
    val coordinates = parsed.fold(State()) { acc, item ->
        when (item.first) {
            "forward" -> State(acc.horizontal + item.second, acc.vertical)
            "down" -> State(acc.horizontal, acc.vertical - item.second)
            "up" -> State(acc.horizontal, acc.vertical + item.second)
            else -> acc
        }
    }
    val result = abs(coordinates.vertical * coordinates.horizontal)
    println(result)
}
