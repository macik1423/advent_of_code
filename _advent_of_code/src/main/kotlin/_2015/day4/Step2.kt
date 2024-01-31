package _2015.day4


fun main(args: Array<String>) {
    val puzzleInput = "yzbqklnj"

    val findNumber = findNumber2(puzzleInput)

    println(findNumber)
}

fun findNumber2(puzzleInput: String): String {
    var n = 0
    while (true) {
        val input = puzzleInput + n
        val md5 = md5(input)
        if (md5.substring(0, 6) == "000000") {
            return input
        }
        n++
    }
}
