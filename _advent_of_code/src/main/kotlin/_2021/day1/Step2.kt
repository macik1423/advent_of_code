package _2021.day1

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2021/day1/input.txt")
    val first = file.subList(0, file.size - 2).map { it.toInt() }
    val second = file.subList(1, file.size - 1).map { it.toInt() }
    val third = file.subList(2, file.size).map { it.toInt() }
    val summed = first.zip(second.zip(third)).map { it.first + it.second.first + it.second.second }
    val summedFirst = summed.subList(0, summed.size - 1)
    val summedSecond = summed.subList(1, summed.size)
    val result = summedFirst.zip(summedSecond).count { it.second > it.first }
    println(result)
}
