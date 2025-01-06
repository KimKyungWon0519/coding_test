import kotlin.math.abs

class Solution_1769 {
    fun minOperations(boxes: String): IntArray {
        val answer: IntArray = IntArray(boxes.length)
        val existIndices: List<Int> =
                boxes.mapIndexedNotNull { index, c -> if (c == '1') index else null }

        for (index in boxes.indices) {
            answer[index] = existIndices.map { it -> abs(it - index) }.sum()
        }

        return answer
    }
}

fun main() {
    println(Solution_1769().minOperations("110").joinToString())
    println(Solution_1769().minOperations("001011").joinToString())
}
