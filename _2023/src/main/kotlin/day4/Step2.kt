package day4

import day1.readFileAsLinesUsingBufferedReader

//1 -> 4 matching 2 3 4 5
//    2 -> 2 matching 3 4
//        3 -> 2 matching 4 5
//            4 -> 1 matching 5
//                5 -> X
//            5 -> X
//        4 -> 1 matching 5
//        5 -> X
//    3 -> 2 matching 4 5
//        4 -> 1 matching 5
//            5 -> X
//        5 -> X
//    4 -> 1 matching 5
//        5 -> X
//    5 -> X
//2 -> 2 matching 3 4
//    3 -> 2 matching 4 5
//        4 -> 1 matching 5
//            5 -> X
//        5 -> X
//    4 -> 1 matching 5
//        5 -> X
//3 -> 2 matching 4 5
//    4 -> 1 matching 5
//        5 -> X
//    5 -> X
//4 -> 1 matching 5
//    5 -> X
//5 -> X
//6 -> X

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/day4/input.txt")
    val splitBy = file.map { Regex("Card\\s+\\d+: ").replace(it, "") }
    val splitBy2 = splitBy.map { it.split("|")}
    val splitBy3 = splitBy2.map { it -> it.map {it.split(" ")} }
    val numbers = splitBy3.map { it -> it.map { it -> it.filter { it.isNotEmpty() }.map { it.toInt() } }}
    val countSame = numbers.map { it -> (it[0] + it[1]).groupingBy { it }.eachCount().filter { it.value > 1 }.keys.toList().count()}
    val listConsecutive = countSame.mapIndexed{ idx, value -> List(value + 1){it + idx + 1} }
    val result = count(listConsecutive)
    print(result)
}

fun count(list: List<List<Int>>): Int {
    val stack = java.util.ArrayDeque<Int>()
    for (i in 1..list.size) {
        stack.add(i)
    }
    var result = 0
    while (stack.size != 0) {
        val pop = stack.pop()
        val l = list[pop - 1].subList(1, list[pop - 1].size)
        for (j in l) {
            stack.add(j)
        }
        result++
    }
    return result
}
