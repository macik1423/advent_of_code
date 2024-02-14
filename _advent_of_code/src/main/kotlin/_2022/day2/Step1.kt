package _2022.day2

import _2015.day1.readFileAsLinesUsingBufferedReader
enum class Point(val value: Int) {
    A(1),
    B(2),
    C(3)
}
data class Game(val opponent: Point, val me: Point)
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day2/input.txt")
    val result = file.map {
        Game(
            when (
                it.split(" ")[0]) {
                "A" -> Point.A // Rock 1
                "B" -> Point.B // Paper 2
                else -> Point.C
            },
            when (
                it.split(" ")[1]) {
                "X" -> Point.A // Rock 1
                "Y" -> Point.B // Paper 2
                else -> Point.C // Scissor 3
            }
        )
    }.fold(0) { acc, item ->
        when {
            item.me == item.opponent -> acc + item.me.value + 3
            item.me == Point.A && item.opponent == Point.B -> acc + item.me.value + 0
            item.me == Point.A && item.opponent == Point.C -> acc + item.me.value + 6
            item.me == Point.B && item.opponent == Point.A -> acc + item.me.value + 6
            item.me == Point.B && item.opponent == Point.C -> acc + item.me.value + 0
            item.me == Point.C && item.opponent == Point.A -> acc + item.me.value + 0
            item.me == Point.C && item.opponent == Point.B -> acc + item.me.value + 6
            else -> acc
        }
    }
    println(result)
}
