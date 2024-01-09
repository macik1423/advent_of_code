package _2015.day3

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day3/input.txt")
    val result = file
        .map { it.toCharArray() }[0]
        .mapIndexed { idx, _ ->
            file[0].substring(0, idx)
            .fold(Pair(0, 0)) { acc, p ->
                when (p) {
                    '^' -> Pair(acc.first, acc.second + 1)
                    'v' -> Pair(acc.first, acc.second - 1)
                    '>' -> Pair(acc.first + 1, acc.second)
                    '<' -> Pair(acc.first - 1, acc.second)
                    else -> acc
                }
            }
        }.toSet().size
    print(result)
}