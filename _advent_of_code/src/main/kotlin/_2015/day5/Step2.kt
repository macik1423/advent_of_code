package _2015.day5

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day5/input.txt")

    val result = file.count { isNiceString2(it) }
    println(result)
}

fun isNiceString2(str: String): Boolean {
    val isContainsAPairOfAnyTwoLettersThatAppearsAtLeastTwiceInTheStringWithoutOverlapping = str.contains(Regex("(\\w{2}).*\\1"))
    val isNotContainMoreThenTwo = !str.contains(Regex("(\\w)\\1{2}"))
    val isContainsAtLeastOneLetterWhichRepeatsWithExactlyOneLetterBetweenThem = str.contains(Regex("(\\w)(?!\\1)\\w\\1"))
    return isContainsAPairOfAnyTwoLettersThatAppearsAtLeastTwiceInTheStringWithoutOverlapping &&
            isNotContainMoreThenTwo &&
            isContainsAtLeastOneLetterWhichRepeatsWithExactlyOneLetterBetweenThem
}