package _2022.day4

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day4/input.txt")
    val data = file.map {
        Pair(
            Range(
                it.split(",")[0].split("-")[0].toInt(),
                it.split(",")[0].split("-")[1].toInt()
            ),
            Range(
                it.split(",")[1].split("-")[0].toInt(),
                it.split(",")[1].split("-")[1].toInt()
            )
        )
    }
    val count = data.size - data.count {
        it.first.start < it.second.start &&
        it.first.end < it.second.end &&
        it.first.end < it.second.start ||
        it.second.start < it.first.start &&
        it.second.end < it.first.end &&
        it.second.end < it.first.start
    }
    println(count)
}