package _2017.day1

import java.io.File

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2017/day1/input.txt")
    val first = file[0]
    val second = file[0].substring(1) + file[0][0]
    val result = first.zip(second).filter { it.first == it.second }.map { Integer.parseInt(it.first.toString()) }.sumOf { it }
    print(result)
}

fun readFileAsLinesUsingBufferedReader(fileName: String): List<String>
        = File(fileName).bufferedReader().readLines()