package _2015.day6

import _2015.day1.readFileAsLinesUsingBufferedReader

enum class Direction {
    ON, OFF, TOGGLE
}

data class Entity(val direction: Direction, val start: Pair<Int, Int>, val end: Pair<Int, Int>)

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day6/input.txt")

    val data = file.map { mapData(it.split(" ")) }

    val arr = Array(1000) { Array(1000) { false } }

    data.forEach {
        when (it.direction) {
            Direction.ON -> {
                for (i: Int in it.start.first..it.end.first) {
                    for (j: Int in it.start.second..it.end.second) {
                        arr[i][j] = true
                    }
                }
            }
            Direction.OFF -> {
                for (i: Int in it.start.first..it.end.first) {
                    for (j: Int in it.start.second..it.end.second) {
                        arr[i][j] = false
                    }
                }
            }
            else -> {
                for (i: Int in it.start.first..it.end.first) {
                    for (j: Int in it.start.second..it.end.second) {
                        arr[i][j] = !arr[i][j]
                    }
                }
            }
        }
    }
    val result = arr.flatMap { row -> row.filter { col -> col } }.count()
    println(result)
}

fun mapData(data: List<String>): Entity {
    return when {
        data.size == 5 -> {
            when {
                data[1] == "on" ->
                    Entity(
                        Direction.ON,
                        Pair(data[2].split(",")[0].toInt(), data[2].split(",")[1].toInt()),
                        Pair(data[4].split(",")[0].toInt(), data[4].split(",")[1].toInt())
                    )
                else ->
                    Entity(
                        Direction.OFF,
                        Pair(data[2].split(",")[0].toInt(), data[2].split(",")[1].toInt()),
                        Pair(data[4].split(",")[0].toInt(), data[4].split(",")[1].toInt())
                    )
            }
        }
        else -> Entity(Direction.TOGGLE, Pair(data[1].split(",")[0].toInt(), data[1].split(",")[1].toInt()),
            Pair(data[3].split(",")[0].toInt(), data[3].split(",")[1].toInt()))
    }
}

