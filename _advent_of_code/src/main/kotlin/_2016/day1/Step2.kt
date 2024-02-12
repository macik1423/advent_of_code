package _2016.day1

import _2015.day1.readFileAsLinesUsingBufferedReader
import kotlin.math.abs

data class State2(
    val cord: Pair<Int, Int> = Pair(0, 0),
    val direction: Direction = North(),
    val points: List<Pair<Int, Int>> = listOf()
)
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2016/day1/input.txt")
    val directions = file[0].split(",").map { it.trim() }.map { Pair(it.substring(0, 1), Integer.parseInt(it.substring(1, it.length))) }
    val path = directions.fold(State2()) { acc, step ->
        when {
            step.first == "R" && acc.direction is North ->
                getState(acc, step, East())

            step.first == "R" && acc.direction is South ->
                getState(acc, step, West())

            step.first == "R" && acc.direction is West ->
                getState(acc, step, North())

            step.first == "R" && acc.direction is East ->
                getState(acc, step, South())

            step.first == "L" && acc.direction is North ->
                getState(acc, step, West())

            step.first == "L" && acc.direction is South ->
                getState(acc, step, East())

            step.first == "L" && acc.direction is East ->
                getState(acc, step, North())

            step.first == "L" && acc.direction is West ->
                getState(acc, step, South())

            else -> State2()
        }
    }
    val firstDuplicated = getFirstDuplicated(path.points)
    val result = abs(firstDuplicated.first) + abs(firstDuplicated.second)
    println(result)
}

private fun getState(acc: State2, step: Pair<String, Int>, direction: Direction) = State2(
    Pair(
        calcX(acc, step, direction),
        calcY(acc, step, direction)
    ),
    direction,
    generatePoints(step, acc, direction)
)

fun generatePoints(step: Pair<String, Int>, acc: State2, direction: Direction): List<Pair<Int, Int>> {
    var endpoint = Pair(0, 0)
    if (acc.points.isNotEmpty()) {
        endpoint = Pair(acc.points.last().first, acc.points.last().second)
    }
    val generated = List(step.second + 1) { Pair(it * direction.getX() + endpoint.first, it * direction.getY() + endpoint.second) }
    val generatedSkipFirst = generated.subList(1, generated.size)
    return listOf(*(arrayOf(acc.points)), *(arrayOf(generatedSkipFirst))).flatten()
}

fun getFirstDuplicated(list: List<Pair<Int, Int>>) : Pair<Int, Int> {
    val storage = mutableListOf<Pair<Int, Int>>()
    for (item in list) {
        if (storage.contains(item)) {
            return item
        }
        storage.add(item)
    }
    return Pair(0, 0)
}

private fun calcY(
    acc: State2,
    step: Pair<String, Int>,
    direction: Direction
) = acc.cord.second + step.second * direction.getY()

private fun calcX(
    acc: State2,
    step: Pair<String, Int>,
    direction: Direction
) = acc.cord.first + step.second * direction.getX()