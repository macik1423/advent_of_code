package _2022.day5

import _2015.day1.readFileAsLinesUsingBufferedReader

//val containers2 = arrayOf(ArrayDeque(listOf("Z", "N")), ArrayDeque(listOf("M", "C", "D")), ArrayDeque(listOf("P")))
val containers2 = arrayOf(
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
        if (it.by > 1) {
            for (i in 0..<it.by) {
                val size = containers2[it.from - 1].size
                val removeLast = containers2[it.from - 1].removeAt(size - it.by + i)
                containers2[it.to - 1].add(removeLast)
            }
        } else {
            val removeLast = containers2[it.from - 1].removeLast()
            containers2[it.to - 1].add(removeLast)
        }
    }
    val result = containers2.joinToString("") { it.last() }
    println(result)
}