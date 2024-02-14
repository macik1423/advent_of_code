package _2021.day1

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2021/day1/input.txt")
    val prev = file.subList(0, file.size - 1).map { it.toInt() }
    val next = file.subList(1, file.size).map {it.toInt()}
    val result = prev.zip(next).count { it.second > it.first }
    println(result)
}
