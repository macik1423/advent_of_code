package _2019.day2

import _2015.day1.readFileAsLinesUsingBufferedReader


fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2019/day2/input.txt")
    val data = file[0].split(",").map { it.toInt() }
    println(data)
    val result = get(data)[0]
    println(get(data))
    println(result)
}

private fun get(data: List<Int>): MutableList<Int> {
    val mutableData = data.toMutableList()
    mutableData[1] = 12
    mutableData[2] = 2
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
