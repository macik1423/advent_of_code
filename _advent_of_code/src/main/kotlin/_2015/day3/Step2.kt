package _2015.day3

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day3/input.txt")

    val santaList = file
        .map { it.toCharArray() }[0]
        .filterIndexed{ idx, _ -> idx % 2 == 0 }
    val resultSanta= List(santaList.size + 1) { idx ->
        santaList
            .subList(0, idx)
            .fold(Pair(0, 0)) { acc, p ->
                roadLogic(p, acc)
            }
    }

    val roboList = file
        .map { it.toCharArray() }[0]
        .filterIndexed{ idx, _ -> idx % 2 == 1 }
    val resultRobo = List(roboList.size + 1) { idx ->
            roboList
            .subList(0, idx)
            .fold(Pair(0, 0)) { acc, p ->
                roadLogic(p, acc)
            }
        }
    println((resultSanta + resultRobo).toSet().size)
}

private fun roadLogic(p: Char, acc: Pair<Int, Int>) = when (p) {
    '^' -> Pair(acc.first, acc.second + 1)
    'v' -> Pair(acc.first, acc.second - 1)
    '>' -> Pair(acc.first + 1, acc.second)
    '<' -> Pair(acc.first - 1, acc.second)
    else -> acc
}