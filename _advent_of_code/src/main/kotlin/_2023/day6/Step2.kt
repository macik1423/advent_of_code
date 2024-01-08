package day6

fun main() {
    val data : List<Pair<Int, Long>> =
        listOf(Pair(55999793, 401148522741405))
    val result = data.fold(1L) { acc, i -> count(i) * acc }
    println(result)
}

private fun count(p: Pair<Int, Long>): Int {
    val list = List(p.first) { index -> index + 1 }
    return list.map { i -> (p.first - i) * 1L * i }.count { it > p.second }
}