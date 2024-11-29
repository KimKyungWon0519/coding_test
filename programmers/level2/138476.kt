class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val filterMap = tangerine.groupBy { it }
        val filterArray = filterMap.map { it.value }.sortedWith { o1, o2 -> o2.size.compareTo(o1.size) }
        var sum = 0
        var count = 0

        for (value in filterArray) {
            sum += value.size
            count++

            if(sum >= k) break
        }

        return count
    }
}

fun main() {
    println(Solution().solution(6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
    println(Solution().solution(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
    println(Solution().solution(2, intArrayOf(1, 1, 1, 1, 2, 2, 2, 3)))
}