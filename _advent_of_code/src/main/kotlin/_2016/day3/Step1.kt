package _2016.day3

import _2017.day1.readFileAsLinesUsingBufferedReader


fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2016/day3/input.txt")
    val data = file.map { it.replace("\\s+".toRegex(), " ").trim().split(" ") }
        .map { Triple(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
    val count = data.count {
        it.first + it.second > it.third &&
        it.third + it.second > it.first &&
        it.first + it.third > it.second
    }
    println(count)
}

