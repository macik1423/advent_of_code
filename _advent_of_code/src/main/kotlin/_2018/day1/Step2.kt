package _2018.day1

fun main(args: Array<String>) {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2018/day1/input.txt")
    val mapped = file.map { Integer.parseInt(it) }.toMutableList()
    
}