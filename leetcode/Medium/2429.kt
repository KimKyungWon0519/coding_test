import kotlin.math.*

class Solution_2429 {
    fun minimizeXor(num1: Int, num2: Int): Int {
        val num1OneIndexed: MutableList<Int> = mutableListOf()
        val num2Binary: String = num2.toString(2)
        var num1Binary: String = num1.toString(2)
        var num2OneCount: Int = num2Binary.count { it == '1' }

        if (num1Binary.length < num2Binary.length) {
            num1Binary = "0".repeat(num2Binary.length - num1Binary.length) + num1Binary
        }

        val num1BinaryLength = num1Binary.length
        val xBinary = CharArray(num1BinaryLength) { '0' }

        for (index in 0 until num1BinaryLength) {
            if (num1Binary[index] == '1') num1OneIndexed.add(index)
        }

        val minLoop = min(num1OneIndexed.size, num2OneCount)

        for (index in 0 until minLoop) {
            xBinary.set(num1OneIndexed[index], '1')

            num2OneCount--
        }

        for (remainCount in 1..num2OneCount) {
            xBinary.set(xBinary.lastIndexOf('0'), '1')
        }

        return xBinary.joinToString("").toInt(2)
    }
}

fun main() {
    println("answer : ${Solution_2429().minimizeXor(3, 5)}")
    println("answer : ${Solution_2429().minimizeXor(1, 12)}")
}
