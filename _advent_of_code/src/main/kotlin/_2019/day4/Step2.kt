package _2019.day4

fun main() {
    val puzzleInput = Pair(240298, 784956)

    val data = List(puzzleInput.second - puzzleInput.first + 1) {idx -> puzzleInput.first + idx}

    val result = data.count { hasDouble(it) && !hasMoreThanTwo(it) && hasIncreases(it) }
    println(result)
}

private fun hasMoreThanTwo(number: Int): Boolean {
    return number.toString().groupingBy { it }.eachCount().count { it.value > 2 } > 0
            && !hasDouble(number)
}

private fun hasDouble(number: Int): Boolean {
    return number.toString().groupingBy { it }.eachCount().count { it.value == 2 } > 0
}

private fun hasIncreases(number: Int): Boolean {
    val numberStr = number.toString()
    val toZip1 = numberStr.substring(0, numberStr.length - 1)
    val toZip2 = numberStr.substring(1, numberStr.length)
    val zipped = toZip1 zip toZip2
    return zipped.count { pair -> Integer.parseInt(pair.first.toString()) <= Integer.parseInt(pair.second.toString())} == numberStr.length - 1
}
