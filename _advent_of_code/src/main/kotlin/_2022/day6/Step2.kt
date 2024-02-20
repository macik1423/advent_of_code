package _2022.day6

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day6/input.txt")

    val listOfSubstrings = mutableListOf<List<Char>>()
    val sizeOfDistinctChars = 14
    for (i in 0..<sizeOfDistinctChars) {
        listOfSubstrings.add(file[0].substring(i, file[0].length - (sizeOfDistinctChars - i - 1)).toCharArray().toList())
    }

    val zip = zip(
        *listOfSubstrings.toTypedArray()
    )
    val firstResult = zip.indexOfFirst { it.toSet().size == it.size }

    val result = firstResult + sizeOfDistinctChars

    println(result)
}
