package _2022.day1

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day1/input.txt")
    val fold = file.fold(State()) { acc, item ->
        when {
            item != "" -> acc.copy(sumPartial = acc.sumPartial + Integer.parseInt(item))
            else -> acc.copy(data = listOf(acc.sumPartial) + acc.data, sumPartial = 0)
        }
    }
    val calories = fold.data + listOf(fold.sumPartial)
    val result = calories.sortedDescending().subList(0, 3).sum()
    println(result)
}