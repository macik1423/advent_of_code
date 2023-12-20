package day3

import day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/day3/input.txt")
    val rows = file.size
    val columns = file[0].length
    val array = Array(rows) { i -> CharArray(columns) { j -> file[i][j] } }

    val result = mutableListOf<Int>()
    for (i in array.indices) {
        var s1 = 0
        var s2 = 0
        var founded = mutableListOf<Boolean>()
        for (j in array[i].indices) {
            val c = array[i][j]
            if (Regex("\\d").matches(c.toString())) {
                founded.add(checkAdjacent(i, j, array))
            } else {
                founded = mutableListOf()
            }
            if (
                j == 0 &&
                Regex("\\d").matches(c.toString()) ||
                j > 0 &&
                !Regex("\\d").matches(array[i][j - 1].toString()) &&
                Regex("\\d").matches(c.toString())
            ) {
                s1 = j
            }
            if (
                j == columns - 1 &&
                Regex("\\d").matches(c.toString()) ||
                j + 1 < columns &&
                !Regex("\\d").matches(array[i][j + 1].toString()) &&
                Regex("\\d").matches(c.toString())
            ) {
                s2 = j
            }

            if (s2 != 0) {
                var number = ""
                for (k in s1..s2) {
                    number += array[i][k]
                }
                if (number.isNotEmpty() && founded.any{ it }) {
                    result.add(number.toInt())
                }
                s1 = 0
                s2 = 0
            }
        }
    }
    print(result.sum())
}

// do przerobienia patrz step 3
fun checkAdjacent(i: Int, j: Int, file: Array<CharArray>): Boolean {
    if (i == 0 && j == 0) {
        if (Regex("[^\\w\\s.]").matches(file[1][0].toString()) ||
            Regex("[^\\w\\s.]").matches(file[1][1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[0][1].toString())
        ) {
            return true
        }
    } else if (i == file.size - 1 && j == file.size - 1) {
        if (Regex("[^\\w\\s.]").matches(file[i - 1][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][j].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i][j - 1].toString())
        ) {
            return true
        }
    } else if (i == 0 && j == file.size - 1) {
        if (Regex("[^\\w\\s.]").matches(file[0][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[1][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[1][j].toString())
        ) {
            return true
        }
    } else if (i == file.size - 1 && j == 0) {
        if (Regex("[^\\w\\s.]").matches(file[i - 1][0].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i][1].toString())
        ) {
            return true
        }
    } else if (i == file.size - 1) {
        if (Regex("[^\\w\\s.]").matches(file[i][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][j].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][j + 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i][j + 1].toString())
        ) {
            return true
        }
    } else if (j == file.size - 1) {
        if (Regex("[^\\w\\s.]").matches(file[i][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][j].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i + 1][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i + 1][j].toString())
        ) {
            return true
        }
    } else if (i == 0) {
        if (Regex("[^\\w\\s.]").matches(file[0][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[1][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[1][j + 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[1][j].toString()) ||
            Regex("[^\\w\\s.]").matches(file[0][j + 1].toString())
        ) {
            return true
        }
    } else if (j == 0) {
        if (Regex("[^\\w\\s.]").matches(file[i - 1][0].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i + 1][0].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i][1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i + 1][1].toString())
        ) {
            return true
        }
    }   else {
        if (Regex("[^\\w\\s.]").matches(file[i - 1][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][j].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i - 1][j + 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i + 1][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i + 1][j].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i + 1][j + 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i][j - 1].toString()) ||
            Regex("[^\\w\\s.]").matches(file[i][j + 1].toString())
        ) {
            return true
        }
    }
    return false
}
