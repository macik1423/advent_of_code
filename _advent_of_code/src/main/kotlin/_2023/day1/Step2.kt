package _2023.day1


fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/day1/input.txt")
    val digits = file.map { detectAndChange(it) }
    val pairsOfDigits = digits.map {
        if (it.size == 1) {
            listOf(it.first(), it.first())
        } else {
            listOf(it.first(), it.last())
        }
    }
    val numbers = pairsOfDigits.map { "${it.first()}${it.last()}" }.map { it.toInt() }
    val sum = numbers.sum()
    print(sum)
}

fun detectAndChange(str: String): List<String> {
    val wordNumbers =
        mapOf(
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )
    val result = mutableListOf<String>()
    for (i in str.indices) {
        if (str[i].isDigit()) {
            result.add(str[i].toString())
        }
        for (j in 0..i)  {
            val sub = str.substring(j, i + 1)
            if (wordNumbers[sub] != null) {
                result.add(wordNumbers.getValue(sub))
            }
        }
    }
    return result
}