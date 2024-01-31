package _2015.day5

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day5/input.txt")

    val result = file.count { isNiceString(it) }
    println(result)
}

fun isNiceString(str: String): Boolean {
    val containsAtLeastThreeVowels = str.map {
        when ("aeiou".toCharArray().contains(it)) {
            true -> 1
            else -> 0
        }
    }.reduce {acc, i -> acc + i} >= 3

    val containsAtLeastOneLetterAppearsTwiceInARow = str.contains(Regex("(.)\\1"))

    val doesNotContainTheStrings = !str.contains(Regex("ab|cd|pq|xy"))

    return containsAtLeastThreeVowels &&
            containsAtLeastOneLetterAppearsTwiceInARow &&
            doesNotContainTheStrings
}