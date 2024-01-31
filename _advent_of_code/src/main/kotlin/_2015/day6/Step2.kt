package _2015.day6

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day6/input.txt")

    val data = file.map { mapData(it.split(" ")) }

    val arr = Array(1000) { Array(1000) { 0 } }

    data.forEach {
        when (it.direction) {
            Direction.ON -> {
                for (i: Int in it.start.first..it.end.first) {
                    for (j: Int in it.start.second..it.end.second) {
                        arr[i][j] += 1
                    }
                }
            }
            Direction.OFF -> {
                for (i: Int in it.start.first..it.end.first) {
                    for (j: Int in it.start.second..it.end.second) {
                        if (arr[i][j] > 0) {
                            arr[i][j] -= 1
                        }
                    }
                }
            }
            else -> {
                for (i: Int in it.start.first..it.end.first) {
                    for (j: Int in it.start.second..it.end.second) {
                        arr[i][j] += 2
                    }
                }
            }
        }
    }
    val result = arr.flatten().reduce { acc, i -> acc + i}
    println(result)
}

