package _2019.day2

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2019/day2/input.txt")
    val data = file[0].split(",").map { it.toInt() }

    val mutableData = data.toMutableList()
    val nounAndVerb = findNounAndVerb(mutableData)
    val result = nounAndVerb.first * 100 + nounAndVerb.second
    println(result)
}

private fun findNounAndVerb(mutableData: MutableList<Int>): Pair<Int, Int> {
    for (i in 0..99) {
        for (j in 0..99) {
            mutableData[1] = i
            mutableData[2] = j
            val result = get(mutableData)[0]
            if (result == 19690720) {
                return Pair(i, j)
            }
        }
    }
    return Pair(0, 0)
}

private fun get(data: List<Int>): MutableList<Int> {
    val mutableData = data.toMutableList()
    var i = 0
    while (true) {
        if (mutableData[i] == 99) return mutableData
        when (mutableData[i]) {
            1 -> {
                mutableData[mutableData[i + 3]] = mutableData[mutableData[i + 1]] + mutableData[mutableData[i + 2]]
                i += 4
            }
            2 -> {
                mutableData[mutableData[i + 3]] = mutableData[mutableData[i + 1]] * mutableData[mutableData[i + 2]]
                i += 4
            }
        }
    }
}