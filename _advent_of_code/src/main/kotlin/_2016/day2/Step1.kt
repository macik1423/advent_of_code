package _2016.day2

import _2017.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2016/day2/input.txt")
    val keypad = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
    val pass = getPassCoordinates(file)
    val map = pass.map {
        keypad[it.first][it.second]
    }
    println(map.joinToString(""))
}

private fun getPassCoordinates(file: List<String>): List<Pair<Int, Int>> {
    val pass = mutableListOf<Pair<Int, Int>>()
    file.forEach {
        when {
            pass.isEmpty() -> pass.add(getLastPoint(Pair(1, 1), it))
            else -> pass.add(getLastPoint(pass.last(), it))
        }
    }
    return pass
}

// [0,0] [0,1] [0,2]
// [1,0] [1,1] [1,2]
// [2,0] [2,1] [2,2]

private fun getLastPoint(startPoint: Pair<Int, Int>, instruction: String): Pair<Int, Int> {
    val coordinates =
        instruction.toCharArray().fold(listOf<Pair<Int, Int>>()) { acc, char ->
            when (char) {
                'U' ->
                    listOf(
                        *acc.toTypedArray(),
                        (when (acc.size) {
                            0 -> u(startPoint)
                            else -> u(acc.last())
                        })
                    )

                'D' ->
                    listOf(
                        *acc.toTypedArray(),
                        (when (acc.size) {
                            0 -> d(startPoint)
                            else -> d(acc.last())
                        })
                    )

                'R' ->
                    listOf(
                        *acc.toTypedArray(),
                        (when (acc.size) {
                            0 -> r(startPoint)
                            else -> r(acc.last())
                        })
                    )

                else ->
                    listOf(
                        *acc.toTypedArray(),
                        (when (acc.size) {
                            0 -> l(startPoint)
                            else -> l(acc.last())
                        })
                    )
            }
        }
    return coordinates.last()
}

private fun r(from: Pair<Int, Int>): Pair<Int, Int> {
    return if (from.second == 2) {
        from
    } else {
        from.copy(second = from.second + 1)
    }
}

private fun l(from: Pair<Int, Int>): Pair<Int, Int> {
    return if (from.second == 0) {
        from
    } else {
        from.copy(second = from.second - 1)
    }
}

private fun u(from: Pair<Int, Int>): Pair<Int, Int> {
    return if (from.first == 0) {
        from
    } else {
        from.copy(first = from.first - 1)
    }
}

private fun d(from: Pair<Int, Int>): Pair<Int, Int> {
    return if (from.first == 2) {
        from
    } else {
        from.copy(first = from.first + 1)
    }
}


