package _2020.day2

data class Requirements2(val firstPosition: Int, val secondPosition: Int, val letter: Char, val word: String)

fun main() {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2020/day2/input.txt")
    val parsed = file.map { Requirements2(parseFirstPosition(it), parseSecondPosition(it), parseLetter2(it), parseWord2(it)) }
    val mapped = parsed.map {
        listOf(it.word[it.firstPosition - 1] == it.letter, it.word[it.secondPosition - 1] == it.letter)
    }
    val result = mapped.map {it.count { iit -> iit } == 1 }.count { it }
    println(result)
}

fun parseFirstPosition(str: String): Int {
    return str.split("-")[0].toInt()
}

fun parseSecondPosition(str: String): Int {
    return str.split("-")[1].split(" ")[0].toInt()
}

fun parseLetter2(str: String): Char {
    return str.split(" ")[1].substring(0, 1).toCharArray()[0]
}

fun parseWord2(str: String): String {
    return str.split(" ")[2]
}
