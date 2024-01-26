package _2017.day1

fun main(args: Array<String>) {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2017/day1/input.txt")
    val first = file[0].substring(0, file[0].length / 2)
    val second = file[0].substring(file[0].length / 2 )
    val result = first.zip(second).filter { it.first == it.second }.sumOf { 2 * Integer.parseInt(it.first.toString()) }
    println(result)
}