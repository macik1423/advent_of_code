package _2016.day1

import _2015.day1.readFileAsLinesUsingBufferedReader
import kotlin.math.abs

interface Direction {
    fun getX(): Int
    fun getY(): Int
}
class North : Direction {
    override fun getX(): Int {
        return 0
    }

    override fun getY(): Int {
        return 1
    }
}

class West : Direction {
    override fun getX(): Int {
        return 1
    }

    override fun getY(): Int {
        return 0
    }
}

class South : Direction {
    override fun getX(): Int {
        return 0
    }

    override fun getY(): Int {
        return -1
    }
}

class East : Direction {
    override fun getX(): Int {
        return -1
    }

    override fun getY(): Int {
        return 0
    }
}

data class State(val cord: Pair<Int, Int> = Pair(0, 0), val direction: Direction = North())
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2016/day1/input.txt")
    val directions = file[0].split(",").map { it.trim() }.map { Pair(it.substring(0, 1), Integer.parseInt(it.substring(1, it.length))) }
    val endingPoint = directions.fold(State()) { acc, step ->
        when {
            step.first == "R" && acc.direction is North ->
                State(
                    Pair(
                        calcX(acc, step, East()),
                        calcY(acc, step, East())
                    ),
                    East()
                )

            step.first == "R" && acc.direction is South ->
                State(
                    Pair(
                        calcX(acc, step, West()),
                        calcY(acc, step, West())
                    ),
                    West()
                )

            step.first == "R" && acc.direction is West ->
                State(
                    Pair(
                        calcX(acc, step, North()),
                        calcY(acc, step, North())
                    ),
                    North()
                )

            step.first == "R" && acc.direction is East ->
                State(
                    Pair(
                        calcX(acc, step, South()),
                        calcY(acc, step, South())
                    ),
                    South()
                )

            step.first == "L" && acc.direction is North ->
                State(
                    Pair(
                        calcX(acc, step, West()),
                        calcY(acc, step, West())
                    ),
                    West()
                )

            step.first == "L" && acc.direction is South ->
                State(
                    Pair(
                        calcX(acc, step, East()),
                        calcY(acc, step, East())
                    ),
                    East()
                )

            step.first == "L" && acc.direction is East ->
                State(
                    Pair(
                        calcX(acc, step, North()),
                        calcY(acc, step, North())
                    ),
                    North()
                )

            step.first == "L" && acc.direction is West ->
                State(
                    Pair(
                        calcX(acc, step, South()),
                        calcY(acc, step, South())
                    ),
                    South()
                )

            else -> State()
        }
    }
    val result = abs(endingPoint.cord.first) + abs(endingPoint.cord.second)
    println(result)
}

private fun calcY(
    acc: State,
    step: Pair<String, Int>,
    direction: Direction
) = acc.cord.second + step.second * direction.getY()

private fun calcX(
    acc: State,
    step: Pair<String, Int>,
    direction: Direction
) = acc.cord.first + step.second * direction.getX()
