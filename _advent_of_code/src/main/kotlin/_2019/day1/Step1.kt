package _2019.day1

import kotlin.math.floor
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2019/day1/input.txt")
    val result = file.sumOf { formula(it.toInt()) }.roundToInt()
    println(result)
}

private fun formula(n: Int): Double {
    return floor(n / 3.0) - 2
}