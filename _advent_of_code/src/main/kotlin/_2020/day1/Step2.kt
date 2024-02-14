package _2020.day1

fun main() {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2020/day1/input.txt")
    val pairs = file
        .flatMap {
            first -> file
            .flatMap { second -> file
                .filter {
                    third ->
                        first != second &&
                        second != third &&
                        first != third
                }
                .map { third -> Triple(first.toInt(), second.toInt(), third.toInt())}
            }
        }
    val result = pairs.first { it.first + it.second + it.third == 2020 }
    val resultProduct = result.first * result.second * result.third
    println(resultProduct)
}