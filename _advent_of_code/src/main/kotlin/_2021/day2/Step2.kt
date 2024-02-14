package _2021.day2

import _2015.day1.readFileAsLinesUsingBufferedReader
import kotlin.math.abs

data class State2(val horizontal: Int = 0, val vertical: Int = 0, val aim: Int = 0)

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2021/day2/input.txt")
    val parsed = file.map { Pair(it.split(" ")[0], Integer.parseInt(it.split(" ")[1])) }
    val coordinates = parsed.fold(State2()) { acc, item ->
        when (item.first) {
            "forward" -> acc.copy(
                horizontal = acc.horizontal + item.second,
                vertical = item.second * acc.aim + acc.vertical
            )
            "down" -> acc.copy(aim = acc.aim + item.second)
            "up" -> acc.copy(aim = acc.aim - item.second)
            else -> acc
        }
    }
    val result = abs(coordinates.vertical * coordinates.horizontal)
    println(result)
}