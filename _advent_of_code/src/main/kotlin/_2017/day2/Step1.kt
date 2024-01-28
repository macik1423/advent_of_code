package _2017.day2

import _2017.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2017/day2/input.txt")
    val result = file
        .map {
            it -> it
                .split("\t")
                .map { Integer.parseInt(it) }
        }
        .sumOf { it.max() - it.min() }
    println(result)
}
