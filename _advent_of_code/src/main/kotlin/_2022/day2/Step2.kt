package _2022.day2

import _2015.day1.readFileAsLinesUsingBufferedReader
// Point.A // Rock 1
// Point.B // Paper 2
// Point.C // Scissor 3
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day2/input.txt")
    val options = file.map { it.split(" ")[1] }
    val opponent = file.map { it.split(" ")[0] }

    val mapIndexed = options.mapIndexed { idx, option ->
        when {
            (option == "X" && opponent[idx] == "A") -> Game(Point.A, Point.C)
            (option == "Y" && opponent[idx] == "A") -> Game(Point.A, Point.A)
            (option == "Z" && opponent[idx] == "A") -> Game(Point.A, Point.B)
            //
            (option == "X" && opponent[idx] == "B") -> Game(Point.B, Point.A)
            (option == "Y" && opponent[idx] == "B") -> Game(Point.B, Point.B)
            (option == "Z" && opponent[idx] == "B") -> Game(Point.B, Point.C)
            //
            (option == "X" && opponent[idx] == "C") -> Game(Point.C, Point.B)
            (option == "Y" && opponent[idx] == "C") -> Game(Point.C, Point.C)
            (option == "Z" && opponent[idx] == "C") -> Game(Point.C, Point.A)
            else -> Game(Point.A, Point.A)
        }
    }
    val result = mapIndexed.fold(0) { acc, item ->
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