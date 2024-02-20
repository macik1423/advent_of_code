package _2022.day5

import _2015.day1.readFileAsLinesUsingBufferedReader

data class Move(val by: Int, val from: Int, val to: Int)

//val containers = arrayOf(ArrayDeque(listOf("Z", "N")), ArrayDeque(listOf("M", "C", "D")), ArrayDeque(listOf("P")))
val containers = arrayOf(
    ArrayDeque(listOf("D", "T", "R", "B", "J", "L", "W", "G")),
    ArrayDeque(listOf("S", "W", "C")),
    ArrayDeque(listOf("R", "Z", "T", "M")),
    ArrayDeque(listOf("D", "T", "C", "H", "S", "P", "V")),
    ArrayDeque(listOf("G", "P", "T", "L", "D", "Z")),
    ArrayDeque(listOf("F", "B", "R", "Z", "J", "Q", "C", "D")),
    ArrayDeque(listOf("S", "B", "D", "J", "M", "F", "T", "R")),
    ArrayDeque(listOf("L", "H", "R", "B", "T", "V", "M")),
    ArrayDeque(listOf("Q", "P", "D", "S", "V"))
)
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day5/input.txt")
    val data = file.map {
        Move(
            it.replace("[^0-9]".toRegex(), " ").trim().replace("\\s+".toRegex(), " ").split(" ")[0].toInt(),
            it.replace("[^0-9]".toRegex(), " ").trim().replace("\\s+".toRegex(), " ").split(" ")[1].toInt(),
            it.replace("[^0-9]".toRegex(), " ").trim().replace("\\s+".toRegex(), " ").split(" ")[2].toInt()
        )
    }

    data.forEach {
        for (i in 0..<it.by) {
            val removeLast = containers[it.from - 1].removeLast()
            containers[it.to - 1].add(removeLast)
        }
    }

    val result = containers.joinToString("") { it.last() }
    println(result)
}