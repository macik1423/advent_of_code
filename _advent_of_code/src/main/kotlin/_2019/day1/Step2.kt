package _2019.day1

import kotlin.math.floor
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2019/day1/input.txt")
    val result = file.sumOf { formula(it.toInt()) - it.toInt()}.roundToInt()

    println(result)
}

private fun formula(n: Int): Double {
    if (n <= 0) return 0.0
    return n + formula(floor(n / 3.0).roundToInt() - 2)
}