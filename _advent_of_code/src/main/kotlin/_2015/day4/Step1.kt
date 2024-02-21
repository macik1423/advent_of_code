package _2015.day4

import java.math.BigInteger
import java.security.MessageDigest

fun main() {
    val puzzleInput = "yzbqklnj"

    val findNumber = findNumber(puzzleInput)

    println(findNumber)
}

fun findNumber(puzzleInput: String): String {
    var n = 0
    while (true) {
        val input = puzzleInput + n
        val md5 = md5(input)
        if (md5.substring(0, 5) == "00000") {
            return input
        }
        n++
    }
}

fun md5(input:String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}