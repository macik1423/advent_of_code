package _2019.day3

import _2015.day1.readFileAsLinesUsingBufferedReader
import kotlin.math.abs

enum class Directions {
    R, U, L, D
}
data class Move(val to: Directions, val by: Int)
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2019/day3/input.txt")

    val path1 = file[0].split(",").map { getMove(it) }
    val path2 = file[1].split(",").map { getMove(it) }

    val traverse1 = traverse(path1)
    val traverse2 = traverse(path2)
    val traverse = traverse1 + traverse2
    val crossPoints = traverse.groupingBy { it }.eachCount().filter { it.value > 1 }
    val nearestCrossPoint = crossPoints.map { abs(it.key.first) + abs(it.key.second) }.minOf { it }
    println(nearestCrossPoint)
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
    return points.toSet().toList()
}