package _2017.day2

import _2017.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2017/day2/input.txt")
    val numbers = file
        .map {
                it -> it
            .split("\t")
            .map { Integer.parseInt(it) }
        }
    val result = numbers.sumOf { getFirstNonZero(it) }
    println(result)
}

fun getFirstNonZero(numbers: List<Int>): Int {
    return numbers.map {
        getMultiplayer(it, numbers)
    }.first { it != 0 }
}

private fun getMultiplayer(it: Int, numbers: List<Int>): Int {
    var n = 2
    while (it * n <= numbers.max()) {
        if (numbers.contains(it * n)) {
            return n
        }
        n++
    }
    return 0
}