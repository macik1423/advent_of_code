package _2018.day2

data class State(val isTwo: Boolean = false, val isThree: Boolean = false)
fun main() {
    val file = _2015.day1.readFileAsLinesUsingBufferedReader("src/main/kotlin/_2018/day2/input.txt")
    val groupingBy = file.map { groupLetters(it) }
        .map {
            when {
                it.containsValue(2) && it.containsValue(3) -> State(isTwo = true, isThree = true)
                it.containsValue(3) -> State(isThree = true)
                it.containsValue(2) -> State(isTwo = true)
                else -> State()
            }
        }
    val countTwo = groupingBy.count { it.isTwo }
    val countThree = groupingBy.count { it.isThree }

    val result = countTwo * countThree
    println(result)
}

private fun groupLetters(str: String): HashMap<Char, Int> {
    val map = HashMap<Char, Int>()
    str.forEach {
        if (map.contains(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }
    return map
}