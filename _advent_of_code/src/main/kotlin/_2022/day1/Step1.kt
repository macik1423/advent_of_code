package _2022.day1

import _2015.day1.readFileAsLinesUsingBufferedReader

data class State(val data: List<Int> = listOf(), val sumPartial: Int = 0)
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day1/input.txt")
    val fold = file.fold(State()) { acc, item ->
        when {
            item != "" -> acc.copy(sumPartial = acc.sumPartial + Integer.parseInt(item))
            else -> acc.copy(data = listOf(acc.sumPartial) + acc.data, sumPartial = 0)
        }
    }
    val result = maxOf(fold.data.max(), fold.sumPartial)
    println(result)
}
