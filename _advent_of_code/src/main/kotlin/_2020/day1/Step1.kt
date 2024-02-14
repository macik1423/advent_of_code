package _2020.day1

fun main() {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2020/day1/input.txt")
    val pairs = file
        .flatMap {
            first -> file
            .filter{ second -> first != second }
            .map{ second -> first to second }
        }
    val result = pairs.first { it.first.toInt() + it.second.toInt() == 2020 }
    val product = result.first.toInt() * result.second.toInt()
    println(product)
}