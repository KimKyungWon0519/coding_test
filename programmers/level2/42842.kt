import kotlin.math.*

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        for (h in yellow downTo 1) {
            if (yellow % h != 0) continue

            val w = yellow / h

            if(w < h) continue

            if(h * 2 + w * 2 + 4 == brown) return intArrayOf(w + 2, h + 2)
        }

        return IntArray(0)
    }
}

fun main() {
    println(Solution().solution(10, 2).joinToString())
    println(Solution().solution(8, 1).joinToString())
    println(Solution().solution(24, 24).joinToString())
}