package _2015.day1

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2015/day1/input.txt")

    val result =
        file
            .map { it.toCharArray() }[0]
            .mapIndexed { idx, _ ->
                Pair(
                    idx,
                    file[0].substring(0, idx).fold(0) { acc, s ->
                        when (s) {
                            '(' -> acc + 1
                            ')' -> acc - 1
                            else -> {
                                acc
                            }
                        }
                    }
                )
            }
            .first { it.second == -1 }
            .first
    print(result)
}
