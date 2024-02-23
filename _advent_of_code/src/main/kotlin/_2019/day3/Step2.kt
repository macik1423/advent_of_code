package _2019.day3

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2019/day3/input.txt")

    val path1 = file[0].split(",").map { getMove(it) }
    val path2 = file[1].split(",").map { getMove(it) }

    val traverse1 = traverse(path1)
    val traverse2 = traverse(path2)
    val traverse: List<Pair<Int, Int>> = traverse1.toSet().toList() + traverse2.toSet().toList()
    val crossPoints = traverse.groupingBy { it }.eachCount().filter { it.value > 1 }

    val pathsToCrossPoints = crossPoints.map {
        val step00 = 1
        val stepsToCrossPoint1 = traverse1.indexOf(it.key) + step00
        val stepsToCrossPoint2 = traverse2.indexOf(it.key) + step00
        stepsToCrossPoint1 + stepsToCrossPoint2
    }
    val minOf = pathsToCrossPoints.minOf { it }
    println(minOf)
}

private fun getMove(it: String) = Move(
    when (it[0]) {
        'R' -> Directions.R
        'U' -> Directions.U
        'L' -> Directions.L
        else -> Directions.D
    },
    it.substring(1, it.length).toInt()
)

private fun traverse(data: List<Move>): List<Pair<Int, Int>> {
    val points = mutableListOf<Pair<Int, Int>>()
    data.forEach {
        val last = if (points.isEmpty()) Pair(0, 0) else points.last()
        val newListPoints = when (it.to) {
            Directions.U -> List(it.by + 1) { idx -> Pair(last.first, last.second + idx)}
            Directions.D -> List(it.by + 1) { idx -> Pair(last.first, last.second - idx)}
            Directions.R -> List(it.by + 1) { idx -> Pair(last.first + idx, last.second)}
            Directions.L -> List(it.by + 1) { idx -> Pair(last.first - idx, last.second)}
        }
        points.addAll(newListPoints.drop(1))
    }
    return points.toList()
}