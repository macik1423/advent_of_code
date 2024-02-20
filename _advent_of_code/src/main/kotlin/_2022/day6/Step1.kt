package _2022.day6

import _2015.day1.readFileAsLinesUsingBufferedReader

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2022/day6/input.txt")
    val first = file[0].substring(0, file[0].length - 3).toCharArray().toList()
    val second = file[0].substring(1, file[0].length - 2).toCharArray().toList()
    val third = file[0].substring(2, file[0].length - 1).toCharArray().toList()
    val fourth = file[0].substring(3, file[0].length).toCharArray().toList()

    val zip = zip(first, second, third, fourth)
    val firstResult = zip.indexOfFirst { it.toSet().size == it.size }
    val sizeOfSingleSubstring = 4
    val result = firstResult + sizeOfSingleSubstring

    println(result)
}

fun <T> zip(vararg lists: List<T>): List<List<T>> {
    return zip(*lists, transform = { it })
}

fun <T, V> zip(vararg lists: List<T>, transform: (List<T>) -> V): List<V> {
    val minSize = lists.minOfOrNull(List<T>::size) ?: return emptyList()
    val list = ArrayList<V>(minSize)

    val iterators = lists.map { it.iterator() }
    var i = 0
    while (i < minSize) {
        list.add(transform(iterators.map { it.next() }))
        i++
    }

    return list
}
