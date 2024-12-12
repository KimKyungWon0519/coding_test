import kotlin.math.*

class Solution_2558 {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        for (second in 0 until k) {
            println(gifts.joinToString())

            var maxNumber: Int = gifts.maxOrNull() ?: continue

            val index: Int = gifts.indexOf(maxNumber)

            maxNumber = sqrt(maxNumber.toDouble()).toInt()

            gifts[index] = maxNumber
        }

        println(gifts.joinToString())

        var sum: Long = 0

        for (gift in gifts) {
            sum += gift
        }

        return sum
    }
}

fun main(args: Array<String>) {
    println(Solution_2558().pickGifts(intArrayOf(25, 64, 9, 4, 100), 4))
    println(Solution_2558().pickGifts(intArrayOf(1, 1, 1, 1), 4))
}
