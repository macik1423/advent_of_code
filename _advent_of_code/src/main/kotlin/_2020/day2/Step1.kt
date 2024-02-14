package _2020.day2

data class Requirements(val atLeast: Int, val atMost: Int, val letter: Char, val word: String)

fun main() {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2020/day2/input.txt")
    val parsed = file.map { Requirements(parseAtLeast(it), parseAtMost(it), parseLetter(it), parseWord(it)) }
    val filterCount = parsed.count {
        it.word.count { iit -> iit == it.letter } >= it.atLeast &&
        it.word.count { iit -> iit == it.letter } <= it.atMost
    }
    println(filterCount)
}

fun parseAtLeast(str: String): Int {
    return str.split("-")[0].toInt()
}

fun parseAtMost(str: String): Int {
    return str.split("-")[1].split(" ")[0].toInt()
}

fun parseLetter(str: String): Char {
    return str.split(" ")[1].substring(0, 1).toCharArray()[0]
}

fun parseWord(str: String): String {
    return str.split(" ")[2]
}
