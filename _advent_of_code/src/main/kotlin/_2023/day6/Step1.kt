package day6

fun main() {
    // t:7 d:9
    // t:1 1 1 1 1 1 1 = 6 (7-1) * 1
    // t:2 2 2 2 2 2 = 10 (7-2) * 2
    // t:3 3 3 3 3 = 12 (7-3) * 3
    // t:4 4 4 4 = 12 (7-4) * 4
    // t:5 5 5 = 10 (7-5) * 5
    // t:6 6 = 6 (7-6)*6
    // t:7 = 0 (7-7)*7
    val data : List<Pair<Int, Int>> =
        listOf(Pair(55, 401), Pair(99, 1485), Pair(97, 2274), Pair(93, 1405))
    val result = data.fold(1) { acc, i -> count(i) * acc }
    println(result)
}

private fun count(p: Pair<Int, Int>): Int {
    val list = List(p.first) { index -> index + 1 }
    return list.map { i -> (p.first - i) * i }.count { it > p.second }
}

