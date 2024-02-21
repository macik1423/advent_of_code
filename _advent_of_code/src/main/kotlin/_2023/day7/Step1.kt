package _2023.day7

import _2023.day1.readFileAsLinesUsingBufferedReader

data class Hand(val cards: String, val bid: Int)
val cards = listOf('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')
fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/_2023/day7/input.txt")
    val data = file.map { Hand(it.split(" ")[0], it.split(" ")[1].toInt()) }
    val comparator = Comparator { a: Hand, b: Hand ->
        compareCards(a, b)
    }
    val sortedBy = data.sortedWith(comparator)
    val result = sortedBy.mapIndexed { idx, it -> (idx + 1) * it.bid }.sum()
    println(result)
}

private fun compareCards(a: Hand, b: Hand) =
    when {
        a.cards.groupingBy { it }.eachCount().maxOf { it.value } > b.cards.groupingBy { it }.eachCount().maxOf { it.value } -> 1
        a.cards.groupingBy { it }.eachCount().maxOf { it.value } == b.cards.groupingBy { it }.eachCount().maxOf { it.value } ->
            when {
                a.cards.groupingBy { it }.eachCount().minOf { it.value } > b.cards.groupingBy { it }.eachCount().minOf { it.value } -> 1
                a.cards.groupingBy { it }.eachCount().minOf { it.value } == b.cards.groupingBy { it }.eachCount().minOf { it.value } ->
                    compareTwoPairs(a, b)
                else -> -1
            }
        else -> -1
    }

private fun compareTwoPairs(a: Hand, b: Hand) = when {
    a.cards.toSet().size < b.cards.toSet().size -> 1
    a.cards.toSet().size == b.cards.toSet().size -> compareLetters(a, b)
    else -> -1
}

private fun compareLetters(a: Hand, b: Hand) = when {
    cards.indexOf(a.cards[0]) > cards.indexOf(b.cards[0]) -> 1
    cards.indexOf(a.cards[0]) == cards.indexOf(b.cards[0]) -> when {
        cards.indexOf(a.cards[1]) > cards.indexOf(b.cards[1]) -> 1
        cards.indexOf(a.cards[1]) == cards.indexOf(b.cards[1]) -> when {
            cards.indexOf(a.cards[2]) > cards.indexOf(b.cards[2]) -> 1
            cards.indexOf(a.cards[2]) == cards.indexOf(b.cards[2]) -> when {
                cards.indexOf(a.cards[3]) > cards.indexOf(b.cards[3]) -> 1
                cards.indexOf(a.cards[3]) == cards.indexOf(b.cards[3]) -> when {
                    cards.indexOf(a.cards[4]) > cards.indexOf(b.cards[4]) -> 1
                    cards.indexOf(a.cards[4]) == cards.indexOf(b.cards[4]) -> 0
                    else -> -1
                }
                else -> -1
            }
            else -> -1
        }
        else -> -1
    }
    else -> -1
}
