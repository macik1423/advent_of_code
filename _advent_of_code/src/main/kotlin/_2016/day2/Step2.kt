package _2016.day2

import _2017.day1.readFileAsLinesUsingBufferedReader
val keypad =
    arrayOf(
        arrayOf("","","1","",""),
        arrayOf("","2","3","4",""),
        arrayOf("5","6","7","8","9"),
        arrayOf("","A","B","C",""),
        arrayOf("","","D","","")
    )
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2016/day2/input.txt")
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
            pass.isEmpty() -> pass.add(getLastPoint(Pair(2, 0), it))
            else -> pass.add(getLastPoint(pass.last(), it))
        }
    }
    return pass
}


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
    return if (from.second == 4 || keypad[from.first][from.second + 1] == "") {
        from
    } else {
        from.copy(second = from.second + 1)
    }
}

private fun l(from: Pair<Int, Int>): Pair<Int, Int> {
    return if (from.second == 0 || keypad[from.first][from.second - 1] == "") {
        from
    } else {
        from.copy(second = from.second - 1)
    }
}

private fun u(from: Pair<Int, Int>): Pair<Int, Int> {
    return if (from.first == 0 || keypad[from.first - 1][from.second] == "") {
        from
    } else {
        from.copy(first = from.first - 1)
    }
}

private fun d(from: Pair<Int, Int>): Pair<Int, Int> {
    return if (from.first == 4 || keypad[from.first + 1][from.second] == "") {
        from
    } else {
        from.copy(first = from.first + 1)
    }
}
