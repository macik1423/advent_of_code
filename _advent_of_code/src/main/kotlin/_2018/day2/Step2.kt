package _2018.day2
data class State2(val w1: String = "", val w2: String = "", val same: String = "")
fun main() {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2018/day2/input.txt")
    val pairs = file
        .flatMap {
                first -> file
            .filter{ second -> first != second }
            .map{ second -> first to second }
        }
    val maxSameCount = pairs.map { State2(it.first, it.second, getSameLetters(it)) }.maxByOrNull { it.same.length }!!
    println(maxSameCount.same)
}

private fun getSameLetters(pair: Pair<String, String>): String {
    val foldIndexed = pair.first.toCharArray().foldIndexed("") { idx, acc, item ->
        when {
            item == pair.second.toCharArray()[idx] -> acc + item
            else -> acc
        }
    }
    return foldIndexed
}